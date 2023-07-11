package com.chocolate.triviatitans.presentation.screens.win_lose_screens.view_model

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.chocolate.triviatitans.domain.usecase.SavePlayerDataUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

class WinViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    savePlayerDataUseCase: SavePlayerDataUseCase
) : ViewModel() {
    private val _state = MutableStateFlow(WinUiState())
    val state = _state.asStateFlow()

    val args = checkNotNull(savedStateHandle["prize"])
    val prizeType = checkNotNull(savedStateHandle["prize"])

    init {

    }
}

data class WinUiState(
    val prize: String = "",
    val image: Int = 0,
)