package com.example.aps.data.model

import com.google.gson.annotations.SerializedName

data class Response(
    @SerializedName("name")
    val name: String,
    @SerializedName("region")
    val region: String,
    @SerializedName("temp")
    val temperature: String,
    @SerializedName("icon")
    val icon: String,
    @SerializedName("us_epa")
    val airQuality: Double,
    @SerializedName("text")
    val condition: String
)
