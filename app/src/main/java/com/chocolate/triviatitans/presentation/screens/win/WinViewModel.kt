package com.chocolate.triviatitans.presentation.screens.win

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chocolate.triviatitans.data.repository.PlayerDataRepository
import com.chocolate.triviatitans.presentation.screens.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WinViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val playerDataRepository: PlayerDataRepository
) : BaseViewModel() {
    private val _state = MutableStateFlow(WinUiState())
    val state = _state.asStateFlow()

     val prizeArgs: PrizeArgs = PrizeArgs(savedStateHandle)

    init {
        viewModelScope.launch {
            playerDataRepository.savePlayerData(prizeArgs.prizeType.toString(), prizeArgs.prize.toString().toInt())
        }
    }
}

data class WinUiState(
    val prize: String = "",
    val image: Int = 0,
)