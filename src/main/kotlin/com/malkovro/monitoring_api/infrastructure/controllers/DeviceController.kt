package com.malkovro.monitoring_api.infrastructure.controllers

import com.malkovro.monitoring_api.bounded_contexts.devices.SwitchLights
import org.springframework.web.bind.annotation.*

@RestController
class DeviceController(private val switchLights: SwitchLights) {
    @PostMapping("/devices/lights")
    fun switchLights(@RequestParam(name = "on") on: Boolean) = switchLights.invoke(on)
}