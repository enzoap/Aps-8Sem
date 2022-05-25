package com.example.clima.presentation

import com.example.clima.presentation.model.WeatherPresentation

sealed class ViewState {
    data class Success (val info: WeatherPresentation) : ViewState()
    data class Error(val message: String) : ViewState()
    object ShowLoading: ViewState()
    object HideLoading: ViewState()
}
