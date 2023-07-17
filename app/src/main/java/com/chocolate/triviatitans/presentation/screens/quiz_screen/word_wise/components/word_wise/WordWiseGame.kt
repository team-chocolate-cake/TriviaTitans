package com.chocolate.triviatitans.presentation.screens.quiz_screen.word_wise.components.word_wise

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.chocolate.triviatitans.presentation.screens.quiz_screen.word_wise.view_model.WordWiseUIState


@Composable
fun WordWiseGame(
    wordWiseUIState: WordWiseUIState,
    onLetterClick: (Char) -> Unit,
) {
    Column(Modifier.padding(horizontal = 16.dp)) {
        QuestionLettersLazyGird(
            charsList = wordWiseUIState
                .questionUiStates[wordWiseUIState.questionNumber].correctAnswerLetters,
            selectedLetterList = wordWiseUIState.selectedLetterList,
        )
        LatterLazyGrid(
            charsList = wordWiseUIState
                .questionUiStates[wordWiseUIState.questionNumber].correctAnswerLetters,
            onLetterClick = onLetterClick
        )
    }
}