package com.malkovro.monitoring_api

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MonitoringApiApplication

fun main(args: Array<String>) {
	runApplication<MonitoringApiApplication>(*args)
}

