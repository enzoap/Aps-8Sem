package com.example.aps.domain.repository

import com.example.aps.presentation.model.ObjectPresentation

interface Repository {
    suspend fun getInfo(): Result<ObjectPresentation>
}