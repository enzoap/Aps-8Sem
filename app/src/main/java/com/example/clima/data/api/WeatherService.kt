package com.example.clima.data.api

import com.example.clima.data.model.WeatherResponse
import retrofit2.http.GET

interface WeatherService {
    @GET("/info")
    suspend fun getInfo(): WeatherResponse
}