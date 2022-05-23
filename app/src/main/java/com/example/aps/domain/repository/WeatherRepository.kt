package com.example.aps.domain.repository

import com.example.aps.domain.model.WeatherModel
import kotlinx.coroutines.flow.Flow

interface WeatherRepository {
    fun getInfo(): Flow<WeatherModel>
}