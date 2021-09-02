package com.example.aps.domain.model

data class ObjectDomain(
    val name: String,
    val region: String,
    val temperature: String,
    val icon: String,
    val airQuality: Double,
    val text: String
)