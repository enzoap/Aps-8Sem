package com.example.clima.domain.repository

import com.example.clima.domain.model.WeatherModel
import kotlinx.coroutines.flow.Flow

interface WeatherRepository {
    fun getInfo(): Flow<WeatherModel>
}