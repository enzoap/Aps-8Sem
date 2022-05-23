package com.example.aps.data.repository

import com.example.aps.data.datasource.WeatherDataSource
import com.example.aps.domain.model.WeatherModel
import com.example.aps.domain.repository.WeatherRepository
import kotlinx.coroutines.flow.Flow

class WeatherRepositoryImpl(
    private val weatherDataSource: WeatherDataSource
): WeatherRepository {

    override fun getInfo(): Flow<WeatherModel> {
        return weatherDataSource.getInfo()
    }
}