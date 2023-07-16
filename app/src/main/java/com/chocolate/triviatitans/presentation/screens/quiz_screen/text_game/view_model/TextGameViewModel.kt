package com.chocolate.triviatitans.presentation.screens.quiz_screen.text_game.view_model

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chocolate.triviatitans.domain.entities.TextChoiceEntity
import com.chocolate.triviatitans.domain.usecase.GetMultiChoiceTextGameUseCase
import com.chocolate.triviatitans.presentation.screens.quiz_screen.base.BaseQuizViewModel
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
) : BaseQuizViewModel(), AnswerCardListener, HintListener {


    init {
        getQuestion()
    }


    override fun getQuestion() {
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
        )    }

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


}