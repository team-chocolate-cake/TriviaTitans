package com.chocolate.triviatitans.presentation.screens.win

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.chocolate.triviatitans.data.repository.PlayerDataRepository
import com.chocolate.triviatitans.presentation.screens.PlayerDataType
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
            when (prizeArgs.prizeType.toString()) {
                PlayerDataType.Bonus.type -> playerDataRepository.savePlayerData(
                    PlayerDataType.Bonus,
                    prizeArgs.prize.toString().toInt()
                )

                PlayerDataType.Hearts.type -> playerDataRepository.savePlayerData(
                    PlayerDataType.Hearts,
                    prizeArgs.prize.toString().toInt()
                )

                PlayerDataType.DeleteTwoAnswers.type -> playerDataRepository.savePlayerData(
                    PlayerDataType.DeleteTwoAnswers,
                    prizeArgs.prize.toString().toInt()
                )

                PlayerDataType.ChangeQuestion.type -> playerDataRepository.savePlayerData(
                    PlayerDataType.ChangeQuestion,
                    prizeArgs.prize.toString().toInt()
                )
            }
            Log.d("args",prizeArgs.prize.toString()+prizeArgs.prizeType.toString())
        }
    }
}

data class WinUiState(
    val prize: String = "",
    val image: Int = 0,
)