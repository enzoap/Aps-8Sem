package com.example.aps.data.api

import com.example.aps.data.model.WeatherResponse
import retrofit2.http.GET

interface WeatherService {
    @GET("/info")
    suspend fun getInfo(): WeatherResponse
}