package com.chocolate.triviatitans.presentation.screens.quiz_screen.word_wise.view_model

sealed class BackPress {
    object Idle : BackPress()
    object InitialTouch : BackPress()
}
