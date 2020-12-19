package com.malkovro.monitoring_api.infrastructure.controllers;

import com.malkovro.monitoring_api.bounded_contexts.measures.CreateMeasure
import com.malkovro.monitoring_api.bounded_contexts.measures.CreateMeasureRequest
import com.malkovro.monitoring_api.bounded_contexts.measures.FilterMeasuresRequest
import com.malkovro.monitoring_api.bounded_contexts.measures.FindAllMeasures
import org.springframework.web.bind.annotation.*

import java.util.*

@RestController
class MeasureController(private val findAllMeasures: FindAllMeasures, private val createMeasure: CreateMeasure) {
	@GetMapping("/measures")
	fun findAll(@RequestParam(name = "name") name: String, @RequestParam(name="rangeFrom", required= false) rangeFrom: Date?, @RequestParam(name="rangeTo", required= false) rangeTo: Date?) = findAllMeasures(FilterMeasuresRequest(name, rangeFrom, rangeTo))

	@PostMapping("/measures")
	fun findAll(@RequestBody createMeasureRequest: CreateMeasureRequest) = createMeasure(createMeasureRequest)
}