package com.chocolate.triviatitans.presentation.screens.quiz_screen.word_wise.view_model

data class WordWiseUIState(
    val isLoading: Boolean = true,
    val questionUiStates: List<QuestionUiState> = emptyList(),
    val error: String? = null,
    val isEmpty: Boolean = false,
    val userScore: Int = 0,
    val questionNumber: Int = 0,
    val levelType: String = "Easy",
    val selectedLetterList: List<Char> = emptyList(),
    val keyboardLetters: List<Char> = emptyList()
) {
    data class QuestionUiState(
        val id: String = "",
        val question: String = "",
        val category: String = "",
        val difficulty: String = "",
        val correctAnswer: List<Char> = emptyList()
    )
}