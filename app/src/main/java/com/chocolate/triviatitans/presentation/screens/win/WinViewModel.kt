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

    val prizeType = checkNotNull(savedStateHandle["prize_type"])
    val args = checkNotNull(savedStateHandle["prize"])

    init {
        viewModelScope.launch {
            when (prizeType.toString()) {
                PlayerDataType.Bonus.name -> savePlayerDataUseCase.savePlayerData(
                    PlayerDataType.Bonus,
                    args.toString().toInt()
                )

                PlayerDataType.Hearts.name -> savePlayerDataUseCase.savePlayerData(
                    PlayerDataType.Hearts,
                    args.toString().toInt()
                )

                PlayerDataType.DeleteTwoAnswers.name -> savePlayerDataUseCase.savePlayerData(
                    PlayerDataType.DeleteTwoAnswers,
                    args.toString().toInt()
                )

                PlayerDataType.ChangeQuestion.name -> savePlayerDataUseCase.savePlayerData(
                    PlayerDataType.ChangeQuestion,
                    args.toString().toInt()
                )
            }
        }
    }
}

data class WinUiState(
    val prize: String = "",
    val image: Int = 0,
)