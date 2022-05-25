package com.example.clima.data.datasource

import com.example.clima.domain.model.WeatherModel
import kotlinx.coroutines.flow.Flow

interface WeatherDataSource {
    fun getInfo(): Flow<WeatherModel>
}