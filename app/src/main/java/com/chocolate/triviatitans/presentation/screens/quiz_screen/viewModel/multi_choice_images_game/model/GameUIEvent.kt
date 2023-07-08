package com.chocolate.triviatitans.presentation.screens.quiz_screen.viewModel.multi_choice_images_game.model

import com.chocolate.triviatitans.presentation.common.type.GameType

sealed interface GameUIEvent {
    data class NavigateToWinnerScreen(val gameType: GameType): GameUIEvent
    object NavigateToLoserScreen: GameUIEvent
    object ShowTimeOut : GameUIEvent
    data class ShowBuyGiftDialog(val message: String): GameUIEvent
    data class ShowSnackBar(val message: String): GameUIEvent
}