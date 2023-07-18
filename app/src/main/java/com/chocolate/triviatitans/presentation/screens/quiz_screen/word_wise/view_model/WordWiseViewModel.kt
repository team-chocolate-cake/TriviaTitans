package com.chocolate.triviatitans.presentation.screens.quiz_screen.word_wise.view_model

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chocolate.triviatitans.domain.entities.TextChoiceEntity
import com.chocolate.triviatitans.domain.usecase.GetMultiChoiceTextGameUseCase
import com.chocolate.triviatitans.presentation.screens.base.BaseViewModel
import com.chocolate.triviatitans.presentation.screens.quiz_screen.text_game.TextGameArgs
import com.chocolate.triviatitans.presentation.screens.quiz_screen.word_wise.WordWiseGameArgs
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WordWiseViewModel @Inject constructor(
    private val getMultiChoiceTextGameUseCase: GetMultiChoiceTextGameUseCase,
    savedStateHandle: SavedStateHandle
) :
    BaseViewModel() {
    private val _state = MutableStateFlow(WordWiseUIState())
    val state = _state.asStateFlow()

    private val textGameArgs: WordWiseGameArgs = WordWiseGameArgs(savedStateHandle)


    init {
        getUserQuestions()
    }

    private fun getUserQuestions() {
        updateState { it.copy(isLoading = true) }
        tryToExecute(
            call = {
                getMultiChoiceTextGameUseCase(10, "science", "hard")
            },
            onSuccess = ::onSuccessUserQuestions,
            onError = ::onErrorUserQuestions
        )
    }

    private fun onSuccessUserQuestions(userQuestions: List<TextChoiceEntity>) {
        updateState {
            it.copy(
                isLoading = false,
                questionUiStates = userQuestions.map { WordWiseMapper().map(it) }
            )
        }
    }

    private fun onErrorUserQuestions(throwable: Throwable) {
        Log.i("questions", "getUserQuestions: $throwable")
    }

    private fun updateState(transform: (WordWiseUIState) -> WordWiseUIState) {
        _state.update(transform)
    }


    fun onLetterClicked(letter: Char) {
        _state.update {
            it.copy(selectedLetterList = _state.value.selectedLetterList + letter)
        }
    }
}