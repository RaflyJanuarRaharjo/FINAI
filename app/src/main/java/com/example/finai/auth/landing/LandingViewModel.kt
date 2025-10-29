package com.example.finai.auth.landing

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

sealed class LandingEvent {
    object OnSignInClicked : LandingEvent()
    object OnSignUpClicked : LandingEvent()
}

sealed class NavigationEvent {
    object NavigateToSignIn : NavigationEvent()
    object NavigateToSignUp : NavigationEvent()
}

class LandingViewModel : ViewModel() {

    private val _navigationEvent = MutableSharedFlow<NavigationEvent>()
    val navigationEvent = _navigationEvent.asSharedFlow()

    fun onEvent(event: LandingEvent) {
        when (event) {
            LandingEvent.OnSignInClicked -> {
                viewModelScope.launch {
                    _navigationEvent.emit(NavigationEvent.NavigateToSignIn)
                }
            }

            LandingEvent.OnSignUpClicked -> {
                viewModelScope.launch {
                    _navigationEvent.emit(NavigationEvent.NavigateToSignUp)
                }
            }
        }
    }
}