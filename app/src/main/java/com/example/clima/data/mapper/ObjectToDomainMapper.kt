package com.example.clima.data.mapper

import com.example.clima.data.model.WeatherResponse
import com.example.clima.domain.model.WeatherModel

fun WeatherResponse.toDomain() = WeatherModel(
    name = name,
    region = region,
    temperature = temperature,
    icon = icon,
    airQuality = airQuality,
    text = condition
)