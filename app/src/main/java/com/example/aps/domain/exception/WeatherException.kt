package com.example.aps.domain.exception

sealed class WeatherException(override val message: String): Throwable() {
    class NoDataException(override val message: String): WeatherException(message)
}