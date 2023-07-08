package com.chocolate.triviatitans.presentation.screens.word_wise_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.chocolate.triviatitans.presentation.screens.quiz_screen.components.Header
import com.chocolate.triviatitans.presentation.screens.word_wise_screen.components.AnswerLetterLazyGird
import com.chocolate.triviatitans.presentation.screens.word_wise_screen.viewModel.WordWiseUIState
import com.chocolate.triviatitans.presentation.screens.word_wise_screen.viewModel.WordWiseViewModel


@Composable
fun WordWiseScreen() {
    val viewModel: WordWiseViewModel = hiltViewModel()
    val state = viewModel.state.collectAsState().value
    WordWiseContent(state = state)
}

@Composable
fun WordWiseContent(
    state: WordWiseUIState,
) {
    if (state.questionUiStates.isNotEmpty()) {
        Column(Modifier.padding(horizontal = 16.dp)) {
            Header(question = state.questionUiStates[state.questionNumber].question)

            AnswerLetterLazyGird(
                charsList = state.questionUiStates[state.questionNumber].correctAnswer.uppercase()
                    .replace(" ", "").toList().shuffled()
            )

            AnswerLetterLazyGird(
                charsList = state.questionUiStates[state.questionNumber].correctAnswer.uppercase()
                    .replace(" ", "").toList().shuffled()
            )

        }
    }
}