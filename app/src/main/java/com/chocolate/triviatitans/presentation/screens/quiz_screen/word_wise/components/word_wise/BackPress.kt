package com.chocolate.triviatitans.presentation.screens.quiz_screen.word_wise.components.word_wise

sealed class BackPress {
    object Idle : BackPress()
    object InitialTouch : BackPress()
}
