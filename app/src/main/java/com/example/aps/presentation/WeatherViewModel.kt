package com.example.aps.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aps.domain.exception.WeatherException
import com.example.aps.domain.usecase.GetWeatherInfoUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class WeatherViewModel(
    private val getWeatherInfoUseCase: GetWeatherInfoUseCase,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
): ViewModel() {

    private val _resultSuccess = MutableLiveData<ViewState>()

    val resultSuccess: LiveData<ViewState>
        get() =_resultSuccess

    init {
        getWeatherInfo()
    }

    fun getWeatherInfo() {
        viewModelScope.launch {
            getWeatherInfoUseCase()
                .flowOn(dispatcher)
                .catch { error -> error.handleThrowable() }
                .onStart { _resultSuccess.postValue(ViewState.ShowLoading) }
                .onCompletion { _resultSuccess.postValue(ViewState.HideLoading) }
                .collect { weatherPresentation ->
                    _resultSuccess.postValue(ViewState.Success(weatherPresentation))
                }
        }
    }

    private fun Throwable.handleThrowable() {
        when (this) {
            is WeatherException.NoDataException -> _resultSuccess.postValue(ViewState.Error(message))
        }
    }
}


