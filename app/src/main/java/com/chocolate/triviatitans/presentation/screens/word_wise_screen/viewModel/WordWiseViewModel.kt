package com.chocolate.triviatitans.presentation.screens.word_wise_screen.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chocolate.triviatitans.domain.entities.TextChoiceEntity
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
class WordWiseViewModel @Inject constructor(private val getUserQuestionsUseCase: GetUserQuestionsUseCase) :
    ViewModel() {
    private val _state = MutableStateFlow(WordWiseUIState())
    val state = _state.asStateFlow()

    init {
        getUserQuestions()
    }

    private fun getUserQuestions() {
        _state.update { it.copy(isLoading = true) }
        tryToExecute(
            call = { getUserQuestionsUseCase(10, "science", "hard") },
            onSuccess = ::onSuccessUserQuestions,
            onError = {
                Log.i("questions", "getUserQuestions: $it")
            }
        )
    }

    private fun onSuccessUserQuestions(userQuestions: List<TextChoiceEntity>) {
        _state.update { it.copy(isLoading = false) }
        val questionsUiState = userQuestions.map { WordWiseMapper().map(it) }
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


}