package com.example.aps.presentation

import android.util.Log
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aps.domain.usecase.GetInfoUseCase
import com.example.aps.presentation.model.ObjectPresentation
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(
    private val useCase: GetInfoUseCase
): ViewModel() {

    private val _resultSuccess = MutableLiveData<ViewAction>()

    val resultSuccess: LiveData<ViewAction>
        get() =_resultSuccess

    fun call() {
        viewModelScope.launch(Dispatchers.IO) {
            kotlin.runCatching {
                useCase()
            }.onSuccess {
                _resultSuccess.postValue(ViewAction.Success(it.getOrNull()!!))
                Log.d("Call", "call() returned: $it")
            }.onFailure {
                _resultSuccess.postValue(ViewAction.Error)
                Log.d("Call", "call() returned: $it")
            }
        }
    }
}