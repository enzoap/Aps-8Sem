package com.example.aps.utils

interface Mapper<S, T> {
    fun map(source: S): T
}