package com.malkovro.monitoring_api.infrastructure.datasources

import com.malkovro.monitoring_api.bounded_contexts.devices.PiAdapter
import com.malkovro.monitoring_api.infrastructure.configuration.ApiConfiguration
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Repository
import java.io.File
import java.util.concurrent.Executors
import java.io.BufferedReader

import java.io.InputStream
import java.io.InputStreamReader
import java.util.function.Consumer


@Repository
class StationPiAdapter(private val configuration: ApiConfiguration) : PiAdapter {
    override fun switchLightsOn(): Boolean {
        return launchCommand("switch light --on")
    }

    override fun switchLightsOff(): Boolean {
        return launchCommand("switch light \"--on=false\"")
    }

    private fun launchCommand(command: String): Boolean {
        val logger: Logger = LoggerFactory.getLogger(StationPiAdapter::class.java)
        val builder = ProcessBuilder()
        builder.command(*buildCmd(command).also { logger.debug(it.joinToString(" ")) })
        builder.directory(File("/app"))
        val process = builder.start()
        val inputStreamGobbler = StreamGobbler(process.inputStream, LoggerConsumer(logger))
        val errorStreamGobbler = StreamGobbler(process.errorStream, LoggerConsumer(logger, true))
        Executors.newSingleThreadExecutor().submit(inputStreamGobbler)
        Executors.newSingleThreadExecutor().submit(errorStreamGobbler)
        return process.waitFor() == 0
    }

    private fun buildCmd(command: String): Array<String> {
        val piConfig = configuration.piConfig()!!
        return arrayOf(
                "./station",
                "remote",
                "--user=${piConfig.user}",
                "--host=${piConfig.host}",
                "--password=${piConfig.password}",
                command,
        )
    }
}

private class LoggerConsumer(val logger: Logger, val isErrorStream: Boolean = false) : Consumer<String> {
    override fun accept(t: String) {
        if (isErrorStream) {
            logger.error(t)
        } else {
            logger.debug(t)
        }
    }

}

private class StreamGobbler(private val inputStream: InputStream, private val consumer: Consumer<String>) : Runnable {
    override fun run() {
        BufferedReader(InputStreamReader(inputStream)).lines()
                .forEach(consumer)
    }

}