package com.malkovro.monitoring_api.bounded_contexts.measures;

import com.fasterxml.jackson.annotation.JsonFormat
import java.util.*

class Measure(
        val name: String,
        val value: Long,
        @JsonFormat(shape = JsonFormat.Shape.NUMBER)
        val measuredAt: Date,
)