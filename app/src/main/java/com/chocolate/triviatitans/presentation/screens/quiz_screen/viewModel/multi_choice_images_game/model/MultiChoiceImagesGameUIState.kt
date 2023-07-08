package com.chocolate.triviatitans.presentation.screens.quiz_screen.viewModel.multi_choice_images_game.model

import com.chocolate.triviatitans.presentation.common.type.GameLevel

data class MultiChoiceImagesGameUIState(
    val isLoading: Boolean = false,
    var questions: List<ImageChoiceUIState> = emptyList(),
    val error: String? = null,
    val isEmpty: Boolean = false,
    val userScore: Int = 0,
    val levelType:String= GameLevel.easy.name,
    val countDownTimer: Int = 30,
    val questionCount: Int = 0,
    val heartCount: Int = 3,
    val points: Int = 0,
    val changeQuestionCount: Int = 0,
    val deleteQuestionCount: Int = 0,
)
