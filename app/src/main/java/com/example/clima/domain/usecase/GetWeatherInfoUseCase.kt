package com.example.clima.domain.usecase

import com.example.clima.domain.mapper.toPresentation
import com.example.clima.domain.repository.WeatherRepository
import com.example.clima.presentation.model.WeatherPresentation
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetWeatherInfoUseCase(
    private val weatherRepository: WeatherRepository
) {
   operator fun invoke(): Flow<WeatherPresentation> {
        return weatherRepository.getInfo().map { weatherModel ->
            weatherModel.toPresentation()
        }
    }
}