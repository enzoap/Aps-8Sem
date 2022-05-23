package com.example.aps.di

import com.example.aps.data.api.WeatherService
import com.example.aps.data.datasource.WeatherRemoteDataSource
import com.example.aps.data.repository.WeatherRepositoryImpl
import com.example.aps.retrofit.HttpClient
import com.example.aps.domain.usecase.GetWeatherInfoUseCase
import com.example.aps.presentation.WeatherViewModel
import com.example.aps.retrofit.RetrofitClient
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val weatherModule = module {

    single { RetrofitClient().newInstance()}
    single { HttpClient(retrofit = get()) }

    viewModel {
        WeatherViewModel(
            getWeatherInfoUseCase = GetWeatherInfoUseCase(
                weatherRepository = WeatherRepositoryImpl(
                    weatherDataSource = WeatherRemoteDataSource(
                        weatherService = get<HttpClient>().create(WeatherService::class.java)
                    )
                )
            )
        )
    }
}