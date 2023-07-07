package com.chocolate.triviatitans.presentation.screens.quiz_screen.viewModel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class QuizScreenViewModel: ViewModel() {

    private val _state = MutableStateFlow(QuizUIState())
    val state = _state.asStateFlow()
}