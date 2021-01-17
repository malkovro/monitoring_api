package com.malkovro.monitoring_api.bounded_contexts.measures

import org.springframework.stereotype.Service

@Service
class CreateBatchMeasures(private val createMeasureRepository: CreateMeasureRepository) {
    operator fun invoke(createMeasureRequests: List<CreateMeasureRequest>): Boolean {
        return createMeasureRepository.createBatch(createMeasureRequests)
    }
}