package com.chocolate.triviatitans.presentation.screens.quiz_screen.viewModel.multi_choice_images_game

import com.chocolate.triviatitans.presentation.common.type.GameLevel
import com.chocolate.triviatitans.presentation.screens.quiz_screen.viewModel.multi_choice_images_game.model.ImageChoiceUIState

data class GameUIState(
    val isLoading: Boolean = false,
    var questions: List<ImageChoiceUIState> = emptyList(),
    val error: String? = null,
    val isEmpty: Boolean = false,
    val userScore: Int = 0,
    val questionNumber: Int = 0,
    val levelType: String = GameLevel.easy.name
)
