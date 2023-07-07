package com.chocolate.triviatitans.presentation.screens.quiz_screen.viewModel

data class QuizUIState(
    val isLoading: Boolean = false,
    var questions: List<Question> = emptyList(),
    val error: String? = null,
    val isEmpty: Boolean = false,
    val userScore: Int = 0,
    val questionNumber: Int = 0,
    val levelType:String="Easy"
) {
    data class Question(
        val id: Int,
        var question: String = "",
        var category: String = "",
        var difficulty: String = "",
        var correctAnswer: String = "",
        var incorrectAnswers: List<String> = emptyList(),
    )
}
