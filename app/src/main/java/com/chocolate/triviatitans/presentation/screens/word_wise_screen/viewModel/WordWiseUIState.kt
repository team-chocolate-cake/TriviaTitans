package com.chocolate.triviatitans.presentation.screens.word_wise_screen.viewModel

data class WordWiseUIState(
    val isLoading: Boolean = true,
    val questionUiStates: List<QuestionUiState> = emptyList(),
    val error: String? = null,
    val isEmpty: Boolean = false,
    val userScore: Int = 0,
    val questionNumber: Int = 0,
    val levelType: String = "Easy"
) {
    data class QuestionUiState(
        val id: String = "",
        val question: String = "",
        val category: String = "",
        val difficulty: String = "",
        val correctAnswer: String = ""
    )
}