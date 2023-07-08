package com.chocolate.triviatitans.presentation.screens.quiz_screen.viewModel

data class MultiChoiceTextUiState(
    val isLoading: Boolean = true,
    val questionUiStates: List<QuestionUiState> = emptyList(),
    val error: String? = null,
    val isEmpty: Boolean = false,
    val userScore: Int = 0,
    val questionNumber: Int = 0,
    val levelType: String = "Easy",
    val isButtonsEnabled:Boolean = true,
) {
    data class QuestionUiState(
        val id: String = "",
        val question: String = "",
        val category: String = "",
        val difficulty: String = "",
        val correctAnswer: String = "",
        val incorrectAnswers: List<String> = emptyList(),
        val randomAnswers:List<String> = (incorrectAnswers.toMutableList() + (correctAnswer))
    ) {
    }

}
