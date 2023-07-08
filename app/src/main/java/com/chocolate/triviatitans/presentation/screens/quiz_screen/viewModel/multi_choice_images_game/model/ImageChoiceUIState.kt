package com.chocolate.triviatitans.presentation.screens.quiz_screen.viewModel.multi_choice_images_game.model

import com.chocolate.triviatitans.domain.entities.InCorrectAnswerImageEntity

data class ImageChoiceUIState(
    val id: String,
    val category: String,
    val correctAnswer: String,
//    val incorrectAnswer: List<List<InCorrectAnswerImageUIState>>,
    val incorrectAnswer: List<String>,
    val question: String,
    val difficulty: String,
    val answers: List<Any> = (incorrectAnswer + correctAnswer).shuffled()
)