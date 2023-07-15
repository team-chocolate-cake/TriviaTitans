package com.chocolate.triviatitans.presentation.screens.win

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chocolate.triviatitans.domain.usecase.SavePlayerDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WinViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val savePlayerDataUseCase: SavePlayerDataUseCase
) : ViewModel() {
    private val _state = MutableStateFlow(WinUiState())
    val state = _state.asStateFlow()

    private val prizeArgs: PrizeArgs = PrizeArgs(savedStateHandle)

    init {
        viewModelScope.launch {
            savePlayerDataUseCase.savePlayerData(prizeArgs.prizeType.toString(), prizeArgs.prize.toString().toInt())
        }
        Log.d("prize", prizeArgs.prizeType.toString() + prizeArgs.prize.toString())
    }
}

data class WinUiState(
    val prize: String = "",
    val image: Int = 0,
)