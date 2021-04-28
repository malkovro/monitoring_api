package com.malkovro.monitoring_api.bounded_contexts.devices

interface PiAdapter {
    fun switchLightsOn(): Boolean
    fun switchLightsOff(): Boolean
}