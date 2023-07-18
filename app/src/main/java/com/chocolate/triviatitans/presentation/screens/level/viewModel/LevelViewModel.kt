package com.chocolate.triviatitans.presentation.screens.level.viewModel

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import com.chocolate.triviatitans.data.local.LocalPlayerDataDto
import com.chocolate.triviatitans.data.repository.PlayerDataRepository
import com.chocolate.triviatitans.presentation.screens.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject
import kotlin.math.log

@HiltViewModel
class LevelViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val playerDataRepository: PlayerDataRepository,
    private val scoreMapper: ScoreMapper
) : BaseViewModel() {

    private val _state = MutableStateFlow(LevelUiState())
    val state = _state.asStateFlow()

    val categoriesArgs = checkNotNull(savedStateHandle["categories"])
    val gameTypeArgs: String = checkNotNull(savedStateHandle["game_type"])

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