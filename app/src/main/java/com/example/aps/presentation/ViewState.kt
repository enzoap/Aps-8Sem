package com.example.aps.presentation

import com.example.aps.presentation.model.WeatherPresentation

sealed class ViewState {
    data class Success (val info: WeatherPresentation) : ViewState()
    data class Error(val message: String) : ViewState()
    object ShowLoading: ViewState()
    object HideLoading: ViewState()
}
