package com.malkovro.monitoring_api.bounded_contexts.measures

import com.malkovro.monitoring_api.infrastructure.datasources.MeasuresDatasource
import org.springframework.stereotype.Component
import java.util.*

@Component
class FindAllMeasuresRepository(private val measuresDatasource: MeasuresDatasource) {
    fun findAll(name: String, rangeFrom: Date?, rangeTo: Date?): List<Measure> {
        return  measuresDatasource.findAll(name, rangeFrom, rangeTo)
    }
}