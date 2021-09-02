package com.example.aps.domain.usecase

import com.example.aps.domain.repository.Repository
import com.example.aps.presentation.model.ObjectPresentation

class GetInfoUseCase(
    private val repository: Repository
) {
    suspend operator fun invoke(): Result<ObjectPresentation> {
        return getInfo(repository.getInfo())
    }

    private fun getInfo(objectPresentation: Result<ObjectPresentation>): Result<ObjectPresentation> {
        var airQuality = ""
        if (objectPresentation.isSuccess){
            when (objectPresentation.getOrNull()?.airQualityIndex) {
                1.0 -> airQuality = "Boa"
                2.0 -> airQuality = "Moderado"
                3.0, 4.0 -> airQuality = "Ruim"
                5.0 -> airQuality = "Muito Ruim"
                6.0 -> airQuality = "Péssima"
            }
            val presentation = objectPresentation.getOrNull()?.copy(airQuality = airQuality)
            return Result.success(presentation!!)
        }
        return Result.failure(Throwable())
    }
}