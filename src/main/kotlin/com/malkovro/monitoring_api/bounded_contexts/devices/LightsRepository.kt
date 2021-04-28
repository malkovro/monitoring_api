package com.malkovro.monitoring_api.bounded_contexts.devices

import org.springframework.stereotype.Component

@Component
class LightsRepository(private val adapter: PiAdapter) {
    fun turnOn(): Boolean {
        return adapter.switchLightsOn()
    }
    fun turnOff(): Boolean {
        return adapter.switchLightsOff()
    }
}