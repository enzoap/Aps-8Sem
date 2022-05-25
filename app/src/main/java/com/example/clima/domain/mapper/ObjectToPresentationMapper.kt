package com.example.clima.domain.mapper

import com.example.clima.domain.model.WeatherModel
import com.example.clima.presentation.model.WeatherPresentation

fun WeatherModel.toPresentation() = WeatherPresentation(
    name = name,
    region = region,
    temperature = temperature,
    icon = icon,
    airQualityIndex = airQuality,
    text = text,
    airQuality = airQualityIndexToAirQuality()
)

fun WeatherModel.airQualityIndexToAirQuality(): String {
    return when (airQuality) {
        1.0 -> "Boa"
        2.0 -> "Moderado"
        3.0, 4.0 -> "Ruim"
        5.0 -> "Muito Ruim"
        6.0 -> "Péssima"
        else -> { "Qualidade do ar indisponível" }
    }
}

