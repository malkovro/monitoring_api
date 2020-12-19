package com.malkovro.monitoring_api.bounded_contexts.measures

import java.util.*

interface FindAllMeasuresDatasource {
    fun findAll(name: String, rangeFrom: Date?, rangeTo: Date?): List<Measure>
}
