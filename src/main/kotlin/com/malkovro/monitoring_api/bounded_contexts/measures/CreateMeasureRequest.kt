package com.malkovro.monitoring_api.bounded_contexts.measures

data class CreateMeasureRequest(val name: String, val value: Double)