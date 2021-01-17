package com.malkovro.monitoring_api.bounded_contexts.measures

interface CreateMeasureDatasource {
    fun create(name: String, value: Double): Measure
    fun createBatch(requests: List<CreateMeasureRequest>): Boolean
}
