package com.chocolate.triviatitans.presentation.screens.quiz_screen.components.multi_choice

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.chocolate.triviatitans.composables.SpacerVertical8
import com.chocolate.triviatitans.presentation.screens.GameType
import com.chocolate.triviatitans.presentation.screens.quiz_screen.listener.AnswerCardListener
import com.chocolate.triviatitans.presentation.screens.quiz_screen.viewModel.multi_choice.MultiChoiceTextUiState
import com.chocolate.triviatitans.presentation.screens.quiz_screen.components.word_wise.LatterLazyGrid
import com.chocolate.triviatitans.presentation.screens.quiz_screen.components.word_wise.QuestionLettersLazyGird
import com.chocolate.triviatitans.presentation.screens.quiz_screen.viewModel.word_wise.WordWiseUIState

@Composable
fun AnswersSection(
    answerCardListener: AnswerCardListener,
    gameType: Int = GameType.MULTI_CHOICE_IMAGES.ordinal,
    question: MultiChoiceTextUiState.QuestionUiState,
    questionNumber: Int,
    isButtonsEnabled: Boolean,
    multiChoiceTextUiState: MultiChoiceTextUiState,
    wordWiseUIState: WordWiseUIState,
    onLetterClick: (Char) -> Unit,
) {
    val givenQuestion = question.randomAnswers

    when (gameType) {
        GameType.MULTI_CHOICE.ordinal -> {
            LazyColumn() {
                itemsIndexed(givenQuestion) { index, questionGiven ->
                    AnswerCard(
                        'A' + index,
                        questionGiven,
                        answerCardListener,
                        questionNumber,
                        question.correctAnswer,
                        isButtonsEnabled
                    )
                    SpacerVertical8()
                }
            }
        }

        GameType.MULTI_CHOICE_IMAGES.ordinal -> {
            MultiChoiceImagesGame(
                state = multiChoiceTextUiState,
                question = question,
                answerCardListener = answerCardListener,
                isButtonsEnabled = isButtonsEnabled
            )
        }

        GameType.WORD_WISE.ordinal -> {
            WordWiseGame(wordWiseUIState = wordWiseUIState, onLetterClick = onLetterClick)
        }
    }
}

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