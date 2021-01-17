package com.malkovro.monitoring_api.bounded_contexts.measures

import org.springframework.stereotype.Service

@Service
class CreateMeasure(private val createMeasureRepository: CreateMeasureRepository) {
    operator fun invoke(createMeasureRequest: CreateMeasureRequest): Measure {
        return createMeasureRepository.create(
                createMeasureRequest.name,
                createMeasureRequest.value,
        )
    }
}