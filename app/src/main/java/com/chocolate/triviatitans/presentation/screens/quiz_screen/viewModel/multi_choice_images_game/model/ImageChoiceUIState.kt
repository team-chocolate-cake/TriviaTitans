package com.chocolate.triviatitans.presentation.screens.quiz_screen.viewModel.multi_choice_images_game.model

import com.chocolate.triviatitans.domain.entities.InCorrectAnswerImageEntity

data class ImageChoiceUIState(
    val id: String,
    val category: String,
    val correctAnswer: String,
    val incorrectAnswer: List<InCorrectAnswerImageEntity>,
    val question: String,
    val difficulty: String,
){
    val answers : List<String> = (incorrectAnswer + correctAnswer).shuffled() as List<String>
}