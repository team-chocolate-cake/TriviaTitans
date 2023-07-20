package com.chocolate.triviatitans.presentation.screens.quiz_screen.base

import com.chocolate.triviatitans.presentation.screens.quiz_screen.HintButton

data class BaseQuizUiState(
    val isLoading: Boolean = true,
    val questionUiStates: List<QuestionUiState> = emptyList(),
    val error: String? = null,
    val isEmpty: Boolean = false,
    val userScore: Int = 0,
    val questionNumber: Int = 0,
    val levelType: String = "Easy",
    val isButtonsEnabled: Boolean = true,
    val hintFiftyFifty: HintButton = HintButton(),
    val hintHeart: HintButton = HintButton(),
    val hintSkip: HintButton = HintButton(),
    val timer:Float=1f
) {

}

data class QuestionUiState(
    val id: String = "",
    val question: String = "",
    val category: String = "",
    val difficulty: String = "",
    val correctAnswer: String = "",
    val incorrectAnswers: List<String> = emptyList(),
    val randomAnswers: List<String> = (((incorrectAnswers.toMutableList()).distinct()).take(3) + (correctAnswer)).shuffled()
)