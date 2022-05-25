package com.example.clima.utils

interface Mapper<S, T> {
    fun map(source: S): T
}