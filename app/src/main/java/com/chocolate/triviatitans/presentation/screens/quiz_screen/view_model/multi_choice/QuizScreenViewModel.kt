package com.chocolate.triviatitans.presentation.screens.quiz_screen.view_model.multi_choice

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chocolate.triviatitans.domain.usecase.GetMultiChoiceImagesGameUseCase
import com.chocolate.triviatitans.presentation.screens.quiz_screen.GameType
import com.chocolate.triviatitans.presentation.screens.quiz_screen.listener.AnswerCardListener
import com.chocolate.triviatitans.presentation.screens.quiz_screen.listener.HintListener
import com.chocolate.triviatitans.presentation.screens.quiz_screen.image_game.view_model.mapper.ImageGameUiMapper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuizScreenViewModel @Inject constructor(
    private val getMultiChoiceImagesGame: GetMultiChoiceImagesGameUseCase,
    private val multiChoiceImagesGameUiMapper: ImageGameUiMapper,
    savedStateHandle: SavedStateHandle,
) : ViewModel(), AnswerCardListener, HintListener {

    private val _state = MutableStateFlow(MultiChoiceTextUiState())
    val state = _state.asStateFlow()

    val categoriesArgs: String = checkNotNull(savedStateHandle["categories"])
    val gameTypeArgs = checkNotNull(savedStateHandle["game_type"])
    val levelTypeArgs: String = checkNotNull(savedStateHandle["level_type"])

    private val gameType = GameType.MULTI_CHOICE_IMAGES.name

    init {
        when (gameType) {
            GameType.MULTI_CHOICE_IMAGES.name -> {
/*
                getUserQuestionsImagesGame()
*/
            }

            else -> {
            }
        }
    }


/*    private fun getUserQuestionsImagesGame() {
        _state.update { it.copy(isLoading = true) }
        tryToExecute(
            call = {
                getMultiChoiceImagesGame(
                    10,
                    categoriesArgs,
                    levelTypeArgs,
                ).map { multiChoiceImagesGameUiMapper.map(it) }
            },
            onSuccess = ::onSuccessUserQuestionsImageGame,
            onError = ::onErrorUserQuestionsImageGame
        )
    }*/

    private fun onSuccessUserQuestionsImageGame(items: List<MultiChoiceTextUiState.QuestionUiState>) {
        _state.update {
            it.copy(
                questionUiStates = items,
                isLoading = false,
                error = null,
            )
        }
    }

    private fun onErrorUserQuestionsImageGame(error: Throwable) {
        Log.i("ERRORX", "onErrorUserQuestionsImageGame: $error")
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
}