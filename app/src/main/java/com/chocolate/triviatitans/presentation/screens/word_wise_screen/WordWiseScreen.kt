package com.chocolate.triviatitans.presentation.screens.word_wise_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.chocolate.triviatitans.presentation.screens.quiz_screen.components.Header
import com.chocolate.triviatitans.presentation.screens.word_wise_screen.components.LatterLazyGrid
import com.chocolate.triviatitans.presentation.screens.word_wise_screen.components.QuestionLettersLazyGird
import com.chocolate.triviatitans.presentation.screens.word_wise_screen.viewModel.WordWiseUIState
import com.chocolate.triviatitans.presentation.screens.word_wise_screen.viewModel.WordWiseViewModel


@Composable
fun WordWiseScreen() {
    val viewModel: WordWiseViewModel = hiltViewModel()
    val state = viewModel.state.collectAsState().value
    WordWiseContent(state = state, onLetterClick = viewModel::onLetterClicked)
}

@Composable
fun WordWiseContent(
    state: WordWiseUIState,
    onLetterClick: (Char) -> Unit,
) {
    if (state.questionUiStates.isNotEmpty()) {
        Column(Modifier.padding(horizontal = 16.dp)) {
            Header(question = state.questionUiStates[state.questionNumber].question)

            QuestionLettersLazyGird(
                charsList = state
                    .questionUiStates[state.questionNumber].correctAnswerLetters,
                selectedLetterList = state.selectedLetterList,
            )
            LatterLazyGrid(
                charsList = listOf(
                    'A',
                    'B',
                    'C',
                    'D',
                    'E',
                    'F',
                    'G',
                    'H',
                    'I',
                    'J',
                    'K',
                    'L',
                    'M',
                    'N',
                    'O',
                    'P',
                    'Q',
                    'R',
                    'S',
                    'T',
                    'U',
                    'V',
                    'X',
                    'Y',
                    'Z'
                ),
                onLetterClick = onLetterClick
            )

        }
    }
}

@Preview
@Composable
fun WorldWiseScreen() {
    WordWiseScreen()
}