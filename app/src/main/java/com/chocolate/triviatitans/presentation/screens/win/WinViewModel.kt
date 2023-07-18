package com.chocolate.triviatitans.presentation.screens.win

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chocolate.triviatitans.data.repository.PlayerDataRepository
import com.chocolate.triviatitans.presentation.screens.PlayerDataType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WinViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val playerDataRepository: PlayerDataRepository
) : ViewModel() {
    private val _state = MutableStateFlow(WinUiState())
    val state = _state.asStateFlow()

    val prizeType = checkNotNull(savedStateHandle["prize_type"])
    val args = checkNotNull(savedStateHandle["prize"])

    init {
        viewModelScope.launch {
            when (prizeType.toString()) {
                PlayerDataType.Bonus.name -> playerDataRepository.savePlayerData(
                    PlayerDataType.Bonus,
                    args.toString().toInt()
                )

                PlayerDataType.Hearts.name -> playerDataRepository.savePlayerData(
                    PlayerDataType.Hearts,
                    args.toString().toInt()
                )

                PlayerDataType.DeleteTwoAnswers.name -> playerDataRepository.savePlayerData(
                    PlayerDataType.DeleteTwoAnswers,
                    args.toString().toInt()
                )

                PlayerDataType.ChangeQuestion.name -> playerDataRepository.savePlayerData(
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