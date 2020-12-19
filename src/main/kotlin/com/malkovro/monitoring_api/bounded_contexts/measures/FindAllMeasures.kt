package com.malkovro.monitoring_api.bounded_contexts.measures

import org.springframework.stereotype.Service

@Service
class FindAllMeasures(private val findAllMeasuresRepository: FindAllMeasuresRepository) {
    operator fun invoke(filterMeasureRequest: FilterMeasuresRequest): List<Measure> {
        return findAllMeasuresRepository.findAll(
                filterMeasureRequest.name,
                filterMeasureRequest.rangeFrom,
                filterMeasureRequest.rangeTo,
        )
    }
}