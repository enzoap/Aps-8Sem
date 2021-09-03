package com.example.aps.presentation

import com.example.aps.presentation.model.ObjectPresentation

sealed class ViewAction {
    data class Success (val info: ObjectPresentation) : ViewAction()
    object Error : ViewAction()
}
