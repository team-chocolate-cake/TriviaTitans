package com.chocolate.triviatitans.presentation.screens.quiz_screen.word_wise.view_model

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.chocolate.triviatitans.domain.entities.TextChoiceEntity
import com.chocolate.triviatitans.domain.usecase.GetMultiChoiceTextGameUseCase
import com.chocolate.triviatitans.presentation.screens.base.BaseViewModel
import com.chocolate.triviatitans.presentation.screens.quiz_screen.listener.HintListener
import com.chocolate.triviatitans.presentation.screens.quiz_screen.word_wise.WordWiseGameArgs
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.util.Locale
import javax.inject.Inject

@HiltViewModel
class WordWiseViewModel @Inject constructor(
    private val getMultiChoiceTextGameUseCase: GetMultiChoiceTextGameUseCase,
    savedStateHandle: SavedStateHandle
) : BaseViewModel(), HintListener {
    private val _state = MutableStateFlow(WordWiseUIState())
    val state = _state.asStateFlow()

    private val wordWiseGameArgs: WordWiseGameArgs = WordWiseGameArgs(savedStateHandle)

    var progressTimer = MutableStateFlow(1f)

    val levelType =
        wordWiseGameArgs.levelType.replaceFirstChar { it.titlecase(Locale.getDefault()) } + " Level"


    init {
        getUserQuestions()
        getKeyboardLetters()
    }

    private fun getUserQuestions() {
        updateState { it.copy(isLoading = true) }
        tryToExecute(
            call = {
                getMultiChoiceTextGameUseCase(10, wordWiseGameArgs.categories, wordWiseGameArgs.levelType)
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
        updateState {
            it.copy(
                isLoading = false,
                error = "${throwable.message}",
            )
        }
    }

    private fun updateState(transform: (WordWiseUIState) -> WordWiseUIState) {
        _state.update(transform)
    }


    private fun getKeyboardLetters() {
        _state.update { it.copy(isLoading = true) }
        _state.update {
            it.copy(
                keyboardLetters = listOf(
                    '1', '2', '3', '4', '5', '6', '7', '8', '9', '0',
                    'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
                    'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
                    'U', 'V', 'W', 'X', 'Y', 'Z', '-'
                )
            )
        }
    }

    fun onLetterClicked(letter: Char) {
        if (_state.value.selectedLetterList.size < _state.value.questionUiStates[_state.value.questionNumber].correctAnswerLetters.size) {
            _state.update {
                it.copy(selectedLetterList = _state.value.selectedLetterList + letter)
            }
        }
    }

    fun onAnswerCardClicked(index: Int) {
        _state.update { currentState ->
            val updatedSelectedLetterList = currentState.selectedLetterList.toMutableList()
            updatedSelectedLetterList.removeAt(index)
            currentState.copy(selectedLetterList = updatedSelectedLetterList)
        }
    }

    fun onClickConfirm(context: Context) {

        when {
            (_state.value.selectedLetterList == _state.value.questionUiStates[_state.value.questionNumber].correctAnswerLetters
                    && _state.value.questionNumber + 1 == _state.value.questionUiStates.size) -> {

                _state.update {
                    it.copy(didUserWin = true)
                }
            }

            (_state.value.selectedLetterList == _state.value.questionUiStates[_state.value.questionNumber].correctAnswerLetters) -> {
                _state.update {
                    it.copy(
                        questionNumber = (it.questionNumber + 1)
                            .takeIf { questionNumber -> questionNumber < it.questionUiStates.size }
                            ?: 0,
                        userScore = it.userScore + 10,
                        selectedLetterList = emptyList(),
                        hintSkip = it.hintSkip.copy(
                            isActive = (it.hintSkip.numberOfTries >= 1) &&
                                    (it.questionNumber == it.questionUiStates.size)
                        ),
                        hintFiftyFifty = it.hintFiftyFifty.copy(
                            isActive = it.hintFiftyFifty.numberOfTries >= 1
                        ),
                        hintHeart = it.hintHeart.copy(
                            isActive = it.hintHeart.numberOfTries >= 1
                        )
                    )
                }
            }


            else -> {
                Toast.makeText(context, "Your Answer is Wrong", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onClickFiftyFifty() {
        _state.update {
            it.copy(
                hintFiftyFifty = it.hintFiftyFifty.copy(
                    numberOfTries = (it.hintFiftyFifty.numberOfTries - 1),
                    isActive = false
                ),
                selectedLetterList = it.questionUiStates[it.questionNumber].correctAnswerLetters.take(
                    it.questionUiStates[it.questionNumber].correctAnswerLetters.size / 2
                )
            )
        }
    }


    override fun onClickHeart() {
        _state.update {
            it.copy(
                hintHeart = it.hintHeart.copy(
                    numberOfTries = (it.hintHeart.numberOfTries - 1),
                    isActive = false
                )
            )
        }
    }

    override fun onClickSkip() {
        _state.update {
            it.copy(
                selectedLetterList = emptyList(),
                questionNumber = it.questionNumber + 1,
                hintSkip = it.hintSkip.copy(
                    numberOfTries = (it.hintSkip.numberOfTries - 1),
                    isActive = false
                )
            )
        }
    }

    fun updateTimer() {
        viewModelScope.launch {
            // (50/1000)/0.002 =25 it takes 25 seconds
            while (progressTimer.value > 0) {
                delay(60)
                progressTimer.value -= 0.002f
                _state.update { it.copy(timer = progressTimer.value) }
            }
            if (_state.value.timer <= 0f) {
                _state.update { it.copy(didUserWin = false) }
            }
        }
    }
}