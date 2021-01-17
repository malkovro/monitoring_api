package com.malkovro.monitoring_api.bounded_contexts.measures

import com.malkovro.monitoring_api.infrastructure.datasources.MeasuresDatasource
import org.springframework.stereotype.Component

@Component
class CreateMeasureRepository(private val measuresDatasource: MeasuresDatasource) {
    fun create(name: String, value: Double): Measure {
        return measuresDatasource.create(name, value)
    }
    fun createBatch(requests: List<CreateMeasureRequest>): Boolean {
        return measuresDatasource.createBatch(requests)
    }
}