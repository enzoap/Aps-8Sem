package com.example.aps.di

import com.example.aps.data.api.Service
import com.example.aps.data.datasource.DataSource
import com.example.aps.data.datasource.DataSourceImpl
import com.example.aps.data.repository.RepositoryImpl
import com.example.aps.data.retrofit.HttpClient
import com.example.aps.data.retrofit.RetrofitClient
import com.example.aps.domain.repository.Repository
import com.example.aps.domain.usecase.GetInfoUseCase
import com.example.aps.presentation.MainViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val domainModules = module {
    factory { GetInfoUseCase(repository = get()) }
}

val presentationModules = module {
    viewModel { MainViewModel(useCase = get()) }
}

val dataModules = module {
    factory<DataSource> { DataSourceImpl(api = get()) }
    factory<Repository> { RepositoryImpl(dataSource = get()) }
}

val networkModules = module {
    single { RetrofitClient(application = androidContext()).newInstance() }
    single { HttpClient(retrofit = get()) }
    factory { get<HttpClient>().create(Service::class.java) }
}