package com.chocolate.triviatitans.presentation.screens.quiz_screen.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chocolate.triviatitans.domain.entities.TextChoiceEntity
import com.chocolate.triviatitans.presentation.screens.quiz_screen.AnswerCardListener
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
    AnswerCardListener {
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
                Log.i("questions", "getUserQuestions: $it")
            }
        )
    }

    private fun onSuccessUserQuestions(userQuestions: List<TextChoiceEntity>) {
        _state.update { it.copy(isLoading = false) }
        val questionsUiState = userQuestions.map { QuizQuestionsMapper().map(it) }
        _state.update { it.copy(questionUiStates = questionsUiState) }
        Log.i("questions", "onSuccessUserQuestions: $questionsUiState")
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
            it.copy(questionNumber =
            (it.questionNumber + 1).takeIf { questionNumber -> questionNumber < 10 }
                ?: 0,
                questionUiStates = it.questionUiStates.map { s -> s.copy(randomAnswers = s.randomAnswers.shuffled()) })
        }
//        Log.i("gg", "question: ${_state.value.questionUiStates[questionNumber].question}")
//        Log.i("gg", "random answers: ${_state.value.questionUiStates[questionNumber].randomAnswers}")
//        Log.i("gg", "incorrect: ${_state.value.questionUiStates[questionNumber].incorrectAnswers}")
//        Log.i("gg", "correct: ${_state.value.questionUiStates[questionNumber].correctAnswer}")
//        return question == _state.value.questionUiStates[questionNumber].question

    }

    override fun updateButtonState(value: Boolean) {
        _state.update {
            it.copy(isButtonsEnabled = value)
        }
    }

    private fun getQuestionColor(question: String, questionNumber: Int): Boolean {
        return question == _state.value.questionUiStates[questionNumber].question
    }
}