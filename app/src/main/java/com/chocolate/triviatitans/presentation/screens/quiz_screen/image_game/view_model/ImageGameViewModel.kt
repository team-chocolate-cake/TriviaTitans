package com.chocolate.triviatitans.presentation.screens.quiz_screen.image_game.view_model

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chocolate.triviatitans.domain.usecase.GetMultiChoiceImagesGameUseCase
import com.chocolate.triviatitans.presentation.screens.quiz_screen.base.BaseQuizViewModel
import com.chocolate.triviatitans.presentation.screens.quiz_screen.base.QuestionUiState
import com.chocolate.triviatitans.presentation.screens.quiz_screen.image_game.view_model.mapper.ImageGameUiMapper
import com.chocolate.triviatitans.presentation.screens.quiz_screen.listener.AnswerCardListener
import com.chocolate.triviatitans.presentation.screens.quiz_screen.listener.HintListener
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ImageGameViewModel @Inject constructor(
    private val getMultiChoiceImagesGame: GetMultiChoiceImagesGameUseCase,
    private val imageGameUiMapper: ImageGameUiMapper,
) : BaseQuizViewModel(), AnswerCardListener, HintListener {


    init {
        getQuestion()
    }

    override fun getQuestion() {
        _state.update { it.copy(isLoading = true) }
        tryToExecute(
            call = {
                getMultiChoiceImagesGame(
                    10,
                    "music",
                    "easy",
                ).map { imageGameUiMapper.map(it) }
            },
            onSuccess = ::onSuccessUserQuestionsImageGame,
            onError = ::onErrorUserQuestionsImageGame
        )
    }

    private fun onSuccessUserQuestionsImageGame(items: List<QuestionUiState>) {
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

}