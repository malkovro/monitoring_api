package com.malkovro.monitoring_api.bounded_contexts.devices

import org.springframework.stereotype.Service

@Service
class SwitchLights(private val repository: LightsRepository) {
    operator fun invoke(on: Boolean): Boolean {
        return if (on) {
            repository.turnOn()
        } else {
            repository.turnOff()
        }
    }
}