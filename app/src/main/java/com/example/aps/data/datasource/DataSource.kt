package com.example.aps.data.datasource

import com.example.aps.domain.model.ObjectDomain

interface DataSource {
    suspend fun getInfo(): ObjectDomain
}