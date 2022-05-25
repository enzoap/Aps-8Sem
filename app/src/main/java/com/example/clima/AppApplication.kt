package com.example.clima

import android.app.Application
import com.example.clima.di.weatherModule
import org.koin.core.context.startKoin

class AppApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(weatherModule)
        }
    }
}