package com.chocolate.triviatitans.presentation.screens.word_wise_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.chocolate.triviatitans.presentation.screens.word_wise_screen.components.AnswerLettersLazyGrid
import com.chocolate.triviatitans.presentation.screens.word_wise_screen.components.ButtonConfirm
import com.chocolate.triviatitans.presentation.screens.word_wise_screen.components.KeyboardLatterLazyGrid
import com.chocolate.triviatitans.presentation.screens.word_wise_screen.viewModel.WordWiseUIState
import com.chocolate.triviatitans.presentation.screens.word_wise_screen.viewModel.WordWiseViewModel


@Composable
fun WordWiseScreen() {
    val viewModel: WordWiseViewModel = hiltViewModel()
    val state = viewModel.state.collectAsState().value
    WordWiseContent(
        state = state,
        onLetterClick = viewModel::onLetterClicked,
        onAnswerCardClicked = viewModel::onAnswerCardClicked,
        onClickConfirm = {}
    )
}

@Composable
fun WordWiseContent(
    state: WordWiseUIState,
    onLetterClick: (Char) -> Unit,
    onAnswerCardClicked: (Int) -> Unit,
    onClickConfirm: () -> Unit
) {
    if (state.questionUiStates.isNotEmpty()) {
        Column(Modifier.padding(horizontal = 16.dp)) {
            //    Header(question = state.questionUiStates[state.questionNumber].question)

            AnswerLettersLazyGrid(
                charsList = state
                    .questionUiStates[state.questionNumber].correctAnswer,
                selectedLetterList = state.selectedLetterList,
                onAnswerCardClicked = onAnswerCardClicked
            )
            KeyboardLatterLazyGrid(
                charsList = state.keyboardLetters,
                onLetterClick = onLetterClick
            )
            ButtonConfirm(onClickConfirm = onClickConfirm)

        }
    }
}
