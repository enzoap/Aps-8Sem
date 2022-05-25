package com.example.clima.presentation.model

data class WeatherPresentation(
    val name: String,
    val region: String,
    val temperature: String,
    val icon: String,
    val airQualityIndex: Double,
    val airQuality: String? = null,
    val text: String
    )