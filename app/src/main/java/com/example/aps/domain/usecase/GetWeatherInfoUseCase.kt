package com.example.aps.domain.usecase

import com.example.aps.domain.mapper.toPresentation
import com.example.aps.domain.model.WeatherModel
import com.example.aps.domain.repository.WeatherRepository
import com.example.aps.presentation.model.WeatherPresentation
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