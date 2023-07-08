package com.chocolate.triviatitans.presentation.screens.quiz_screen.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chocolate.triviatitans.domain.entities.TextChoiceEntity
import com.chocolate.triviatitans.presentation.screens.quiz_screen.listener.AnswerCardListener
import com.chocolate.triviatitans.presentation.screens.quiz_screen.listener.HintListener
import com.chocolate.triviatitans.usecase.GetUserQuestionsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuizScreenViewModel @Inject constructor(private val getUserQuestionsUseCase: GetUserQuestionsUseCase) :
    ViewModel(),
    AnswerCardListener, HintListener {
    private val _state = MutableStateFlow(MultiChoiceTextUiState())
    val state = _state.asStateFlow()

    init {
        getUserQuestions()
    }

    private fun getUserQuestions() {
        _state.update { it.copy(isLoading = true) }
        tryToExecute(
            call = { getUserQuestionsUseCase(10, "science", "easy") },
            onSuccess = ::onSuccessUserQuestions,
            onError = {
            }
        )
    }

    private fun onSuccessUserQuestions(userQuestions: List<TextChoiceEntity>) {
        _state.update { it.copy(isLoading = false) }
        val questionsUiState = userQuestions.map { QuizQuestionsMapper().map(it) }
        _state.update { it.copy(questionUiStates = questionsUiState) }
    }

    private fun <T> tryToExecute(
        call: suspend () -> T,
        onSuccess: (T) -> Unit,
        onError: (Throwable) -> Unit,
        dispatcher: CoroutineDispatcher = Dispatchers.IO
    ) {
        viewModelScope.launch(dispatcher) {
            try {
                call().also(onSuccess)
            } catch (th: Throwable) {
                onError(th)
            }
        }
    }

    override fun onClickCard(question: String, questionNumber: Int) {
        _state.update {
            it.copy(
                questionNumber = (it.questionNumber + 1)
                    .takeIf { questionNumber -> questionNumber < it.questionUiStates.size } ?: 0,
                questionUiStates = it.questionUiStates.map
                { question -> question.copy(randomAnswers = question.randomAnswers.shuffled()) },
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
            it.copy(
                hintFiftyFifty = it.hintFiftyFifty.copy(
                    numberOfTries = (it.hintFiftyFifty.numberOfTries - 1),
                    isActive = it.hintFiftyFifty.numberOfTries >= 2
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
                    isActive = it.hintHeart.numberOfTries >= 2
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
                    isActive = it.hintReset.numberOfTries >= 2
                )
            )
        }
    }
}