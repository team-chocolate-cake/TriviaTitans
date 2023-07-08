package com.chocolate.triviatitans.presentation.screens.quiz_screen.viewModel.multi_choice_images_game

import android.util.Log
import com.chocolate.triviatitans.data.repository.NoNetworkThrowable
import com.chocolate.triviatitans.domain.usecase.GetMultiChoiceImagesGameUseCase
import com.chocolate.triviatitans.presentation.base.BaseViewModel
import com.chocolate.triviatitans.presentation.common.type.GameLevel
import com.chocolate.triviatitans.presentation.screens.quiz_screen.viewModel.multi_choice_images_game.mapper.MultiChoiceImagesGameUiMapper
import com.chocolate.triviatitans.presentation.screens.quiz_screen.viewModel.multi_choice_images_game.model.GameListener
import com.chocolate.triviatitans.presentation.screens.quiz_screen.viewModel.multi_choice_images_game.model.GameUIEvent
import com.chocolate.triviatitans.presentation.screens.quiz_screen.viewModel.multi_choice_images_game.model.ImageChoiceUIState
import com.chocolate.triviatitans.presentation.screens.quiz_screen.viewModel.multi_choice_images_game.model.MultiChoiceImagesGameUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import java.net.SocketTimeoutException
import javax.inject.Inject

@HiltViewModel
class MultiChoiceImagesGameViewModel @Inject constructor(
    private val getQuestionsUseCase: GetMultiChoiceImagesGameUseCase,
    private val multiChoiceImagesGameUiMapper: MultiChoiceImagesGameUiMapper,
) : BaseViewModel<MultiChoiceImagesGameUIState, GameUIEvent>(MultiChoiceImagesGameUIState()),
    GameListener {

    init {
        getQuestions()
    }

    private fun getQuestions() {
        _state.update { it.copy(isLoading = true) }
        tryToExecute(
            call = {
                getQuestionsUseCase(
                    limit = LIMIT,
                    categories = "music",
                    difficulties = GameLevel.easy.name
                ).map { multiChoiceImagesGameUiMapper.map(it) }
                    .also { Log.i("bb", "getQuestions:$it ") }
            },
            onSuccess = ::onGetAllQuestionsSuccess,
            onError = ::onError,
        )
    }

    private fun onGetAllQuestionsSuccess(items: List<ImageChoiceUIState>) {
        _state.update {
            it.copy(
                questions = items,
                isLoading = false,
                error = null,
            )
        }
    }

    private fun onError(throwable: Throwable) {
        if (throwable == NoNetworkThrowable()) {
            showErrorWithSnackBar(throwable.message ?: "No Network Connection")
        } else if (throwable == SocketTimeoutException()) {
            showErrorWithSnackBar(throwable.message ?: "time out!")
        }
        _state.update {
            it.copy(
                error = throwable.message ?: "No Network Connection",
                isLoading = false
            )
        }
    }

    private fun showErrorWithSnackBar(messages: String) {
        sendEvent(GameUIEvent.ShowSnackBar(messages))
    }


    override fun onClickAnswer(answerPosition: Int) {

        _state.update {
            it.copy(questionCount =
            (it.questionCount + 1).takeIf { questionCount -> questionCount < 10 }
                ?: 0,
                questions = it.questions.map { s ->
                    s.copy(answers = s.answers) })
        }
    }


    private companion object {
        private const val LIMIT = 10
    }
}