package com.chocolate.triviatitans.presentation.screens.quiz_screen.word_wise.view_model

import com.chocolate.triviatitans.presentation.screens.quiz_screen.HintButton

data class WordWiseUIState(
    val isLoading: Boolean = true,
    val questionUiStates: List<QuestionUiState> = emptyList(),
    val error: String? = null,
    val isEmpty: Boolean = false,
    val userScore: Int = 0,
    val questionNumber: Int = 0,
    val levelType: String = "",
    val selectedLetterList: List<Char> = emptyList(),
    val keyboardLetters: List<Char> = emptyList(),
    val hintFiftyFifty: HintButton = HintButton(),
    val hintHeart: HintButton = HintButton(),
    val hintReset: HintButton = HintButton(),
    val didUserWin: Boolean = false,
    val didUserLose: Boolean = false,
    val timer:Float=1f
) {
    data class QuestionUiState(
        val id: String = "",
        val question: String = "",
        val category: String = "",
        val difficulty: String = "",
        val correctAnswer: String,
        val correctAnswerLetters: List<Char> = emptyList()
    )
}