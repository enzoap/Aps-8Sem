package com.example.aps.data.api

import com.example.aps.data.model.Response
import retrofit2.http.GET

interface Service {
    @GET("/info")
    suspend fun getInfo(): Response
}