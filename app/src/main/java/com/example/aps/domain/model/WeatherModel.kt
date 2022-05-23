package com.example.aps.domain.model

data class WeatherModel(
    val name: String,
    val region: String,
    val temperature: String,
    val icon: String,
    val airQuality: Double,
    val text: String
)