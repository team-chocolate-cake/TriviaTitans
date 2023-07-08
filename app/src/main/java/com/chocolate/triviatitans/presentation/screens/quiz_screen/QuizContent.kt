package com.chocolate.triviatitans.presentation.screens.quiz_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.chocolate.triviatitans.composables.SpacerVertical16
import com.chocolate.triviatitans.presentation.screens.quiz_screen.components.AnswersSection
import com.chocolate.triviatitans.presentation.screens.quiz_screen.components.Header
import com.chocolate.triviatitans.presentation.screens.quiz_screen.viewModel.MultiChoiceTextUiState
import com.chocolate.triviatitans.presentation.screens.quiz_screen.viewModel.QuizScreenViewModel
import com.chocolate.triviatitans.presentation.theme.TriviaCustomColors
import com.chocolate.triviatitans.presentation.theme.TriviaTitansTheme

@Composable
fun QuizScreen() {
    val viewModel: QuizScreenViewModel = hiltViewModel()
    val state = viewModel.state.collectAsState().value
    QuizContent(multiChoiceTextUiState = state, viewModel, state.isButtonsEnabled)
}

@Composable
fun QuizContent(
    multiChoiceTextUiState: MultiChoiceTextUiState,
    answerCardListener: AnswerCardListener,
    isButtonsEnabled: Boolean
) {
    Column(
        Modifier
            .fillMaxSize()
            .background(color = TriviaCustomColors.current.background)
            .padding(horizontal = 16.dp, vertical = 16.dp)
    ) {
        if (multiChoiceTextUiState.questionUiStates.isNotEmpty()) {
            Header(multiChoiceTextUiState.questionUiStates[multiChoiceTextUiState.questionNumber].question)
            SpacerVertical16()
            AnswersSection(
                answerCardListener,
                question = multiChoiceTextUiState.questionUiStates[multiChoiceTextUiState.questionNumber],
                questionNumber = multiChoiceTextUiState.questionNumber,
                isButtonsEnabled = isButtonsEnabled
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun QuizScreenPreview() {
    TriviaTitansTheme() {
        QuizContent(MultiChoiceTextUiState(), object : AnswerCardListener {
            override fun onClickCard(question: String, questionNumber: Int) {
                TODO("Not yet implemented")
            }

            override fun updateButtonState(value: Boolean) {
                TODO("Not yet implemented")
            }
        }, isButtonsEnabled = true)
    }
}

