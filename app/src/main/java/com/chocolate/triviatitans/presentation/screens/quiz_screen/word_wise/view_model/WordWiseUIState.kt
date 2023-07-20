package com.chocolate.triviatitans.presentation.screens.quiz_screen.word_wise.view_model

import com.chocolate.triviatitans.presentation.screens.quiz_screen.HintButton

data class WordWiseUIState(
    val isLoading: Boolean = true,
    val questionUiStates: List<QuestionUiState> = emptyList(),
    val error: String? = null,
    val userScore: Int = 0,
    val questionNumber: Int = 0,
    val selectedLetterList: List<Char> = emptyList(),
    val keyboardLetters: List<Char> = emptyList(),
    val hintFiftyFifty: HintButton = HintButton(),
    val hintHeart: HintButton = HintButton(),
    val hintSkip: HintButton = HintButton(),
    val didUserWin: Boolean? = null,
    val timer: Float = 1f
) {
    data class QuestionUiState(
        val id: String = "",
        val question: String = "",
        val difficulty: String = "",
        val correctAnswer: String,
        val correctAnswerLetters: List<Char> = emptyList()
    )
}