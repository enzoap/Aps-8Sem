package com.example.aps.data.repository

import com.example.aps.data.datasource.DataSource
import com.example.aps.domain.mapper.ObjectToPresentationMapper
import com.example.aps.domain.repository.Repository
import com.example.aps.presentation.model.ObjectPresentation

class RepositoryImpl(
    private val dataSource: DataSource
): Repository {
    private val mapper = ObjectToPresentationMapper()

    override suspend fun getInfo(): Result<ObjectPresentation> {
        return Result.success(mapper.map(dataSource.getInfo()))
    }
}