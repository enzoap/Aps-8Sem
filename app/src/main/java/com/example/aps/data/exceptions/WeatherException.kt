package com.example.aps.data.exceptions

import com.google.gson.annotations.SerializedName

data class WeatherException(
    @SerializedName("errorMessage")
    val errorMessage: String
)