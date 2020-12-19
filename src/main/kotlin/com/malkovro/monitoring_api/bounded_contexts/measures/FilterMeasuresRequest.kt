package com.malkovro.monitoring_api.bounded_contexts.measures

import java.util.*

data class FilterMeasuresRequest(val name: String, val rangeFrom: Date?, val rangeTo: Date?)