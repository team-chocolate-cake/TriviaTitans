package com.chocolate.triviatitans.presentation.screens.quiz_screen.image_game.view_model

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import com.chocolate.triviatitans.data.repository.PlayerDataRepository
import com.chocolate.triviatitans.data.repository.TriviaTitansRepository
import com.chocolate.triviatitans.domain.entities.ImageChoiceEntity
import com.chocolate.triviatitans.domain.mapper.player_data.DomainPlayerDataMapper
import com.chocolate.triviatitans.presentation.screens.quiz_screen.base.BaseQuizViewModel
import com.chocolate.triviatitans.presentation.screens.quiz_screen.image_game.ImageGameArgs
import com.chocolate.triviatitans.presentation.screens.quiz_screen.image_game.view_model.mapper.ImageGameUiMapper
import com.chocolate.triviatitans.presentation.screens.quiz_screen.listener.AnswerCardListener
import com.chocolate.triviatitans.presentation.screens.quiz_screen.listener.HintListener
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class ImageGameViewModel @Inject constructor(
    private val repository: TriviaTitansRepository,
    private val imageGameUiMapper: ImageGameUiMapper,
    savedStateHandle: SavedStateHandle,
    override val playerDataRepository: PlayerDataRepository,
    override val domainPlayerDataMapper: DomainPlayerDataMapper
) : BaseQuizViewModel(), AnswerCardListener, HintListener {


    init {
        getPlayerData()
        getQuestion()
    }

    private val imageGameArgs: ImageGameArgs = ImageGameArgs(savedStateHandle)

    override fun getQuestion() {
        _state.update { it.copy(isLoading = true) }
        tryToExecute(
            call = {
                repository.getImageChoiceQuestions(
                    10,
                    imageGameArgs.categories,
                    imageGameArgs.levelType
                )

            },
            onSuccess = ::onSuccessUserQuestionsImageGame,
            onError = ::onErrorUserQuestionsImageGame
        )
    }

    private fun onSuccessUserQuestionsImageGame(items: List<ImageChoiceEntity>) {
        _state.update {
            it.copy(
                questionUiStates = items.map { imageGameUiMapper.map(it) },
                isLoading = false,
                error = null,
            )
        }
    }


    private fun onErrorUserQuestionsImageGame(error: Throwable) {
        Log.i("ERRORX", "onErrorUserQuestionsImageGame: $error")
        _state.update {
            it.copy(
                isLoading = false,
                error = "${error.message}",
            )
        }
    }

}