package com.chocolate.triviatitans.view_model.level

import android.util.Log
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class LevelViewModel @Inject constructor(

): ViewModel() {
    private val _state = MutableStateFlow(LevelUiState())
    val state = _state.asStateFlow()

    init {
        getScore()
    }

    private fun getScore() {
        when(_state.value.selectedLevel){
            TypeLevel.Easy -> {
                _state.update {
                    it.copy(
                        score = it.score
                    )
                }
            }
            TypeLevel.Medium -> {
                _state.update {
                    it.copy(
                        score = it.score * 2
                    )
                }
            }
            TypeLevel.Hard -> {
                _state.update {
                    it.copy(
                        score = it.score * 3
                    )
                }
            }
        }
    }

    fun updateSelectedLevel(level: TypeLevel) {
        when(level){
            TypeLevel.Easy -> {_state.update { it.copy(selectedLevel = level) }}
            TypeLevel.Medium -> {_state.update { it.copy(selectedLevel = level) }}
            TypeLevel.Hard -> {_state.update { it.copy(selectedLevel = level) }}
        }
        getScore()
    }
}