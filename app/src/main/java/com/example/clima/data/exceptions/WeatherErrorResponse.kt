package com.example.clima.data.exceptions

import com.google.gson.annotations.SerializedName

data class WeatherErrorResponse(
    @SerializedName("errorMessage")
    val errorMessage: String
)
