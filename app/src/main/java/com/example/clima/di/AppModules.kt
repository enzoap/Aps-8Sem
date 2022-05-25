package com.example.clima.di

import com.example.clima.data.api.WeatherService
import com.example.clima.data.datasource.WeatherRemoteDataSource
import com.example.clima.data.repository.WeatherRepositoryImpl
import com.example.clima.retrofit.HttpClient
import com.example.clima.domain.usecase.GetWeatherInfoUseCase
import com.example.clima.presentation.WeatherViewModel
import com.example.clima.retrofit.RetrofitClient
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