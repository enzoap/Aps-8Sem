package com.example.aps.data.datasource

import com.example.aps.data.api.Service
import com.example.aps.data.mapper.ObjectToDomainMapper
import com.example.aps.domain.model.ObjectDomain

class DataSourceImpl(
    private val api: Service
): DataSource {
    private val mapper = ObjectToDomainMapper()

    override suspend fun getInfo(): ObjectDomain = mapper.map(api.getInfo())
}