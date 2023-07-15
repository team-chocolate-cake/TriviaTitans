package com.chocolate.triviatitans.presentation.screens.quiz_screen.text_game.view_model

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chocolate.triviatitans.domain.entities.TextChoiceEntity
import com.chocolate.triviatitans.domain.usecase.GetMultiChoiceTextGameUseCase
import com.chocolate.triviatitans.presentation.screens.quiz_screen.listener.AnswerCardListener
import com.chocolate.triviatitans.presentation.screens.quiz_screen.listener.HintListener
import com.chocolate.triviatitans.presentation.screens.quiz_screen.text_game.view_model.mapper.QuestionsMapper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TextGameViewModel @Inject constructor(
    private val getMultiChoiceTextGame: GetMultiChoiceTextGameUseCase,
) : ViewModel(), AnswerCardListener, HintListener {

    private val _state = MutableStateFlow(TextGameUiState())
    val state = _state.asStateFlow()


    init {
        getQuestions()
    }

    private fun getQuestions() {
        _state.update { it.copy(isLoading = true) }
        tryToExecute(
            call = {
                getMultiChoiceTextGame(
                    10,
                    "music",
                    "easy",
                )
            },
            onSuccess = ::onGetQuestionsSuccess,
            onError = ::onGetQuestionsError
        )
    }

    private fun onGetQuestionsSuccess(questions: List<TextChoiceEntity>) {
        Log.i("ERRORX", "onSuccessUserQuestionsTextGame: $questions")
        _state.update {
            it.copy(
                isLoading = false,
                questionUiStates = questions.map { choice -> QuestionsMapper().map(choice) }
            )
        }
    }

    private fun onGetQuestionsError(error: Throwable) {
        Log.i("ERRORX", "onErrorUserQuestionsTextGame: $error")
    }


    override fun onClickCard(question: String, questionNumber: Int, isCorrectAnswer: Boolean) {
        _state.update {
            it.copy(
                questionNumber = (it.questionNumber + 1)
                    .takeIf { questionNumber -> questionNumber < it.questionUiStates.size } ?: 0,
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
            val isLastQuestion = it.questionNumber == it.questionUiStates.size
            it.copy(
                questionNumber = it.questionNumber + 1,
                hintReset = it.hintReset.copy(
                    numberOfTries = (it.hintReset.numberOfTries - 1),
                    isActive =
                    it.hintReset.numberOfTries > 1 && isLastQuestion

                )
            )
        }
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

}