package com.chocolate.triviatitans.presentation.screens.quiz_screen.base

import androidx.lifecycle.viewModelScope
import com.chocolate.triviatitans.data.local.LocalPlayerDataDto
import com.chocolate.triviatitans.data.repository.PlayerDataRepository
import com.chocolate.triviatitans.domain.mapper.player_data.DomainPlayerDataMapper
import com.chocolate.triviatitans.presentation.screens.PlayerDataType
import com.chocolate.triviatitans.presentation.screens.base.BaseViewModel
import com.chocolate.triviatitans.presentation.screens.quiz_screen.listener.AnswerCardListener
import com.chocolate.triviatitans.presentation.screens.quiz_screen.listener.HintListener
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

abstract class BaseQuizViewModel : BaseViewModel(), AnswerCardListener, HintListener {

    protected val _state = MutableStateFlow(BaseQuizUiState())
    val state = _state.asStateFlow()

    var progressTimer = MutableStateFlow(1f)

    abstract val playerDataRepository: PlayerDataRepository

    abstract val domainPlayerDataMapper: DomainPlayerDataMapper
    abstract fun getQuestion()

    private fun updatePlayerHintsData() {
        tryToExecute(
            call = {
                playerDataRepository.savePlayerData(
                    PlayerDataType.ChangeQuestion,
                    _state.value.hintSkip.numberOfTries
                )
                playerDataRepository.savePlayerData(
                    PlayerDataType.DeleteTwoAnswers,
                    _state.value.hintFiftyFifty.numberOfTries
                )
                playerDataRepository.savePlayerData(
                    PlayerDataType.Hearts,
                    _state.value.hintHeart.numberOfTries
                )
            },
            onSuccess = ::onUpdatePlayerHintData,
            onError = ::onErrorPlayerData
        )
    }

    private fun onUpdatePlayerHintData(unit: Unit) {}

    fun getPlayerData() {
        tryToExecute(
            call = { playerDataRepository.getPlayerData() },
            onSuccess = ::onSuccessPlayerData,
            onError = ::onErrorPlayerData,

            )
    }

    private fun onErrorPlayerData(throwable: Throwable) {
        _state.update {
            it.copy(
                error = throwable.message
            )
        }
    }

    private fun onSuccessPlayerData(localPlayerDataDto: LocalPlayerDataDto) {
        val playerData = domainPlayerDataMapper.map(localPlayerDataDto)
        _state.update {
            it.copy(
                hintFiftyFifty = it.hintFiftyFifty.copy(
                    numberOfTries = playerData.deleteTwoAnswers
                ),
                hintHeart = it.hintHeart.copy(
                    numberOfTries = playerData.hearts
                ),
                hintSkip = it.hintSkip.copy(
                    numberOfTries = playerData.changeQuestion
                ),
            )
        }
    }


    override fun onClickCard(isCorrectAnswer: Boolean) {
        when {
            (isCorrectAnswer && _state.value.questionNumber + 1 == _state.value.questionUiStates.size) -> {
                updatePlayerHintsData()
                _state.update {
                    it.copy(didPlayerWin = true)
                }
            }

            isCorrectAnswer -> _state.update {
                it.copy(
                    questionNumber = (it.questionNumber + 1)
                        .takeIf { questionNumber -> questionNumber < it.questionUiStates.size }
                        ?: 0,
                    hintFiftyFifty = it.hintFiftyFifty.copy(
                        isActive = it.hintFiftyFifty.numberOfTries >= 1
                    ),
                    hintHeart = it.hintHeart.copy(
                        isActive = it.hintHeart.numberOfTries >= 1
                    ),
                    hintSkip = it.hintSkip.copy(
                        isActive = it.hintSkip.numberOfTries >= 1 && it.questionNumber == it.questionUiStates.size
                    ),
                    questionUiStates = it.questionUiStates.map
                    { question -> question.copy(randomAnswers = question.randomAnswers.shuffled()) },
                    userScore =  it.userScore + 10

                )
            }

            else -> {
                updatePlayerHintsData()
                _state.update {
                    it.copy(didPlayerWin = false)
                }
            }
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
                    isActive = false,
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
                    isActive = false
                )
            )
        }
    }

    override fun onClickSkip() {
        _state.update {
            it.copy(
                questionNumber = it.questionNumber + 1,
                hintSkip = it.hintSkip.copy(
                    numberOfTries = (it.hintSkip.numberOfTries - 1),
                    isActive = false
                ),
                hintHeart = it.hintHeart.copy(
                    isActive = it.hintHeart.numberOfTries >= 1
                ),
                hintFiftyFifty = it.hintFiftyFifty.copy(
                    isActive = it.hintFiftyFifty.numberOfTries >= 1
                )
            )
        }
    }

    // to calculate timer per second{ (delayTime/1000) / the decreasing number }ol
    fun updateTimer() {
        viewModelScope.launch {
            // (60/1000)/0.002 =30 it takes 30 seconds
            while (progressTimer.value > 0) {
                delay(60)
                progressTimer.value -= 0.002f
                _state.update { it.copy(timer = progressTimer.value) }
            }
            if (_state.value.timer <= 0f) {
                updatePlayerHintsData()
                _state.update { it.copy(didPlayerWin = false) }
            }
        }
    }

}
