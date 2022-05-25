package com.example.clima.data.repository

import com.example.clima.data.datasource.WeatherDataSource
import com.example.clima.domain.model.WeatherModel
import com.example.clima.domain.repository.WeatherRepository
import kotlinx.coroutines.flow.Flow

class WeatherRepositoryImpl(
    private val weatherDataSource: WeatherDataSource
): WeatherRepository {

    override fun getInfo(): Flow<WeatherModel> {
        return weatherDataSource.getInfo()
    }
}