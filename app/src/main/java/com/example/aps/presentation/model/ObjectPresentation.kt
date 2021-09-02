package com.example.aps.presentation.model

data class ObjectPresentation(
    val name: String,
    val region: String,
    val temperature: String,
    val icon: String,
    val airQualityIndex: Double,
    val airQuality: String? = null,
    val text: String
    )