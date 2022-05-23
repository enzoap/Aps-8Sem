package com.example.aps.data.datasource

import com.example.aps.domain.model.WeatherModel
import kotlinx.coroutines.flow.Flow

interface WeatherDataSource {
    fun getInfo(): Flow<WeatherModel>
}