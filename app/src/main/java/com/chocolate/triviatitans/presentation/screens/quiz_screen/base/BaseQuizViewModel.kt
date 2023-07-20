package com.chocolate.triviatitans.presentation.screens.quiz_screen.base

import androidx.lifecycle.viewModelScope
import com.chocolate.triviatitans.presentation.screens.base.BaseViewModel
import com.chocolate.triviatitans.presentation.screens.quiz_screen.listener.AnswerCardListener
import com.chocolate.triviatitans.presentation.screens.quiz_screen.listener.HintListener
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

abstract class BaseQuizViewModel : BaseViewModel(), AnswerCardListener, HintListener {

    protected val _state = MutableStateFlow(BaseQuizUiState())
    val state = _state.asStateFlow()

    var progressTimer = MutableStateFlow(1f)

    abstract fun getQuestion()

    override fun onClickCard(question: String, questionNumber: Int, isCorrectAnswer: Boolean) {
        _state.update {
            it.copy(
                questionNumber = (it.questionNumber + 1)
                    .takeIf { questionNumber -> questionNumber < it.questionUiStates.size } ?: 0,
                hintFiftyFifty = it.hintFiftyFifty.copy(
                    isActive = it.hintFiftyFifty.numberOfTries>=1
                ),
                hintHeart = it.hintHeart.copy(
                    isActive = it.hintHeart.numberOfTries>=1
                ),
                hintReset = it.hintReset.copy(
                    isActive = it.hintReset.numberOfTries >= 1 && it.questionNumber != it.questionUiStates.size
                ),
                currentQuestion = true,
                questionUiStates = it.questionUiStates.map
                { question -> question.copy(randomAnswers = question.randomAnswers.shuffled()) },
                userScore = if (isCorrectAnswer) it.userScore + 10 else it.userScore
            )
        }
    }

    override fun updateButtonState(value: Boolean) {
        _state.update {
            it.copy(isButtonsEnabled = value)
        }
    }

    override fun onClickFiftyFifty() {

        _state.update {
            val isNextQuestion = it.currentQuestion

            it.copy(
                currentQuestion = false,
                hintFiftyFifty = it.hintFiftyFifty.copy(
                    numberOfTries = (it.hintFiftyFifty.numberOfTries - 1),
                    isActive = false,
                ),
            )
        }
        _state.update { item ->
            val currentQuestionNumber = state.value.questionNumber
            val currentQuestionUiStates = state.value.questionUiStates
            val updatedQuestionUiStates =
                currentQuestionUiStates.mapIndexed { index, questionUiState ->
                    if (index == currentQuestionNumber) {
                        val filteredQuestions =
                            (questionUiState.incorrectAnswers - questionUiState.correctAnswer)
                                .shuffled()
                                .take(1) + questionUiState.correctAnswer

                        questionUiState.copy(randomAnswers = filteredQuestions)
                    } else {
                        questionUiState
                    }
                }
            item.copy(questionUiStates = updatedQuestionUiStates)
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

    override fun onClickReset() {
        _state.update {
            it.copy(
                questionNumber = it.questionNumber + 1,
                hintReset = it.hintReset.copy(
                    numberOfTries = (it.hintReset.numberOfTries - 1),
                    isActive = false
                ),
                hintHeart = it.hintHeart.copy(
                    isActive = it.hintHeart.numberOfTries>=1
                ),
                hintFiftyFifty = it.hintFiftyFifty.copy(
                    isActive = it.hintFiftyFifty.numberOfTries>=1
                )
            )
        }
    }

    // to calculate timer per second{ (delayTime/1000) / the decreasing number }ol
    fun updateTimer() {
        viewModelScope.launch {
            // (50/1000)/0.002 =25 it takes 25 seconds
            while (progressTimer.value > 0) {
                delay(50)
                progressTimer.value -= 0.002f
                _state.update { it.copy(timer = progressTimer.value) }
            }
        }
    }

}
