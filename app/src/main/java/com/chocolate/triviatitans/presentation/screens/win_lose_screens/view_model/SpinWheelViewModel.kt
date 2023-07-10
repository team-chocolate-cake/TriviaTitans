package com.chocolate.triviatitans.presentation.screens.win_lose_screens.view_model

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

class SpinWheelViewModel @Inject constructor() : ViewModel() {
    private val _state = MutableStateFlow(SpinWheelUiState())
    val state = _state.asStateFlow()

    init {
        _state.update { it.copy(prize = state.value.prize) }
    }
}

data class SpinWheelUiState(
    val prize: String = "",
    val image: Int = 0,
)