package com.chocolate.triviatitans.presentation.screens.quiz_screen.text_game.view_model

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import com.chocolate.triviatitans.data.repository.PlayerDataRepository
import com.chocolate.triviatitans.data.repository.TriviaTitansRepository
import com.chocolate.triviatitans.domain.entities.TextChoiceEntity
import com.chocolate.triviatitans.domain.mapper.player_data.DomainPlayerDataMapper
import com.chocolate.triviatitans.presentation.screens.quiz_screen.base.BaseQuizViewModel
import com.chocolate.triviatitans.presentation.screens.quiz_screen.listener.AnswerCardListener
import com.chocolate.triviatitans.presentation.screens.quiz_screen.listener.HintListener
import com.chocolate.triviatitans.presentation.screens.quiz_screen.text_game.TextGameArgs
import com.chocolate.triviatitans.presentation.screens.quiz_screen.text_game.view_model.mapper.QuestionsMapper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class TextGameViewModel @Inject constructor(
    private val repository: TriviaTitansRepository,
    private val questionsMapper: QuestionsMapper,
    savedStateHandle: SavedStateHandle,
    override val playerDataRepository: PlayerDataRepository,
    override val domainPlayerDataMapper: DomainPlayerDataMapper
) : BaseQuizViewModel(), AnswerCardListener, HintListener {


    init {
        getPlayerData()
        getQuestion()
    }

    private val textGameArgs: TextGameArgs = TextGameArgs(savedStateHandle)


    override fun getQuestion() {
        _state.update { it.copy(isLoading = true) }
        tryToExecute(
            call = {
                repository.getTextChoiceQuestions(
                    10,
                    textGameArgs.categories,
                    textGameArgs.levelType
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
                questionUiStates = questions.map { choice -> questionsMapper.map(choice) }
            )
        }
    }

    private fun onGetQuestionsError(error: Throwable) {
        Log.i("ERRORX", "onErrorUserQuestionsImageGame: $error")
        _state.update {
            it.copy(
                isLoading = false,
                error = "${error.message}",
            )
        }
    }


}