package com.chocolate.triviatitans.presentation.screens.level.viewModel

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import com.chocolate.triviatitans.data.local.LocalPlayerDataDto
import com.chocolate.triviatitans.data.repository.PlayerDataRepository
import com.chocolate.triviatitans.presentation.screens.base.BaseViewModel
import com.chocolate.triviatitans.presentation.screens.level.LevelArgs
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LevelViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val playerDataRepository: PlayerDataRepository,
    private val scoreMapper: ScoreMapper
) : BaseViewModel() {

    private val _state = MutableStateFlow(LevelUiState())
    val state = _state.asStateFlow()


    val levelArgs: LevelArgs = LevelArgs(savedStateHandle)

    init {
        getPlayerData()
    }

    private fun getPlayerData() {
        tryToExecute(
            call = { playerDataRepository.getPlayerData() },
            onSuccess = ::onGetPlayerDataSuccess,
            onError = ::onGetPlayerDataError
        )
    }

    private fun onGetPlayerDataError(throwable: Throwable) {
        //todo handle errors
    }

    private fun onGetPlayerDataSuccess(playerDataDto: LocalPlayerDataDto) {
        _state.update {
            it.copy(
                score = scoreMapper.map(playerDataDto)
            )
        }
    }

    fun updateSelectedLevel(level: TypeLevel) {
        _state.update { it.copy(selectedLevel = level) }
    }
}