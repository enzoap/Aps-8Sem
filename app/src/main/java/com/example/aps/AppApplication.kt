package com.example.aps

import android.app.Application
import com.example.aps.di.weatherModule
import org.koin.core.context.startKoin

class AppApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(weatherModule)
        }
    }
}