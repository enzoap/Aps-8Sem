package com.example.aps.data.mapper

import com.example.aps.data.model.WeatherResponse
import com.example.aps.domain.model.WeatherModel
import com.example.aps.utils.Mapper

fun WeatherResponse.toDomain() = WeatherModel(
    name = name,
    region = region,
    temperature = temperature,
    icon = icon,
    airQuality = airQuality,
    text = condition
)