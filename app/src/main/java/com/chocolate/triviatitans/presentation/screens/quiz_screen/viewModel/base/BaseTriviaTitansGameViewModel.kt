//package com.chocolate.triviatitans.presentation.screens.quiz_screen.viewModel.base
//
//import androidx.lifecycle.viewModelScope
//import com.chocolate.triviatitans.presentation.base.BaseViewModel
//import com.chocolate.triviatitans.presentation.common.type.GameType
//import com.chocolate.triviatitans.presentation.screens.quiz_screen.viewModel.QuizUIState
//import com.chocolate.triviatitans.presentation.screens.quiz_screen.viewModel.model.GameListener
//import com.chocolate.triviatitans.presentation.screens.quiz_screen.viewModel.model.GameUIEvent
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.Job
//import kotlinx.coroutines.cancel
//import kotlinx.coroutines.delay
//import kotlinx.coroutines.flow.update
//import kotlinx.coroutines.launch
//
//abstract class BaseTriviaTitansGameViewModel<T>(
//    state: QuizUIState,
//) : BaseViewModel<QuizUIState, GameUIEvent>(state), GameListener {
//    abstract val gameType: GameType
//    abstract val getQuestion: suspend () -> T
//    private var timerJob: Job? = null
//
//    abstract suspend fun levelUpUseCase()
//
//    abstract suspend fun updateQuestionCountUseCase(questionCount: Int)
//
//    protected fun getData() {
//        _state.update { it.copy(isLoading = true,) }
//        getUserQuestion()
//    }
//
//
//
//    private fun getUserQuestion() {
//        tryToExecute(
//            call = getQuestion::invoke,
//            ::onSuccessQuestion,
//            ::onError
//        )
//    }
//
//
//    open fun onSuccessQuestion(questionEntity: T) {
//        _state.update {
//            it.copy(
//                question = questionEntity,
//                answers = questionEntity.choices.mapIndexed { index, answer ->
//                    GameUiState.AnswerUiState(
//                        index,
//                        answer,
//                        index == questionEntity.correctAnswerPosition
//                    )
//                },
//                correctAnswerPosition = questionEntity.correctAnswerPosition,
//                imageUrl = questionEntity.imageUrl,
//                isError = false,
//                isLoading = false
//            )
//        }
//        initTimer()
//    }
//    //endregion
//
//    //region timer
//    private fun initTimer() {
//        _state.update { it.copy(countDownTimer = 30) }
//        timerJob?.cancel()
//        timerJob = viewModelScope.launch {
//            while (true) {
//                if (_state.value.countDownTimer == 0) {
//                    onTimeout()
//                    timerJob = null
//                    cancel()
//                }
//                delay(1000)
//                _state.update { it.copy(countDownTimer = it.countDownTimer - 1) }
//            }
//        }
//    }
//
//    private fun onTimeout() {
//        viewModelScope.launch {
//            sendEvent(GameUIEvent.ShowTimeOut)
//            delay(1000)
//            sendEvent(GameUIEvent.NavigateToLoserScreen)
//        }
//    }
//
//    //endregion
//
//    //region handle question
//    override fun onClickAnswer(answerPosition: Int) {
//        viewModelScope.launch {
//            _state.update { it.copy(userAnswer = answerPosition) }
//            delay(500)
//            val isCorrectAnswer = _state.value.correctAnswerPosition == answerPosition
//            when {
//                (!isCorrectAnswer && state.value.heartCount == 1) -> handleIncorrectAnswerWithNoHearts()
//                (!isCorrectAnswer) -> handleIncorrectAnswerWithRemainingHearts()
//                else -> onQuestionCompletion()
//            }
//        }
//    }
//
//    private fun handleIncorrectAnswerWithNoHearts() {
//        state.value.apply {
//            when {
//                points < requiredPointsForHearts(level) ->
//                    sendEvent(GameUIEvent.NavigateToLoserScreen)
//
//                else -> {
//                    sendEvent(GameUIEvent.ShowBuyHeartDialog(requiredPointsForHearts(level)))
//                    timerJob?.cancel()
//                }
//            }
//        }
//    }
//
//    private fun requiredPointsForHearts(level: Int): Int {
//        return when (level) {
//            1 -> HEARTS_POINTS_FOR_EASY_LEVEL
//            2 -> HEARTS_POINTS_FOR_MEDIUM_LEVEL
//            3 -> HEARTS_POINTS_FOR_HARD_LEVEL
//            else -> 0
//        }
//    }
//
//    private fun handleIncorrectAnswerWithRemainingHearts() {
//        _state.update { it.copy(heartCount = state.value.heartCount - 1) }
//        getData()
//    }
//
//    private fun onQuestionCompletion() {
//        if (_state.value.isLastQuestion) {
//            viewModelScope.launch { onUserWins() }
//        } else {
//            updateToNextQuestion()
//        }
//    }
//
//    private fun onUserWins() {
//        viewModelScope.launch(Dispatchers.IO) {
//            runCatching {
//                updateUserPointsUseCase(_state.value.points)
//                updateQuestionCountUseCase(_state.value.questionCount)
//                levelUpUseCase()
//                sendEvent(GameUIEvent.NavigateToWinnerScreen(gameType))
//            }.onFailure(::onError)
//        }
//    }
//
//    private fun updateToNextQuestion() {
//        viewModelScope.launch(Dispatchers.IO) {
//            runCatching {
//                updateQuestionCountUseCase(_state.value.questionCount)
//                _state.update { it.copy(points = it.points + (it.level * 10)) }
//                updateUserPointsUseCase(_state.value.points)
//                getData()
//            }.onFailure(::onError)
//        }
//    }
//    //endregion
//
//    fun buyHearts(numberOfPoints: Int) {
//        _state.update { it.copy(points = it.points - numberOfPoints, heartCount = 3) }
//        viewModelScope.launch {
//            updateUserPointsUseCase(_state.value.points)
//        }
//        initTimer()
//    }
//
//    private fun onError(throwable: Throwable) {
//        _state.update { it.copy(isError = true) }
//        sendEvent(GameUIEvent.ShowSnackbar(throwable.message.toString()))
//    }
//
//    companion object {
//        const val HEARTS_POINTS_FOR_EASY_LEVEL = 30
//        const val HEARTS_POINTS_FOR_MEDIUM_LEVEL = 60
//        const val HEARTS_POINTS_FOR_HARD_LEVEL = 150
//    }
//}