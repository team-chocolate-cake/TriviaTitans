package com.chocolate.triviatitans.presentation.screens.quiz_screen.components.multi_choice

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import com.chocolate.triviatitans.composables.SpacerVertical8
import com.chocolate.triviatitans.presentation.screens.GameType
import com.chocolate.triviatitans.presentation.screens.quiz_screen.components.word_wise.WordWiseGame
import com.chocolate.triviatitans.presentation.screens.quiz_screen.listener.AnswerCardListener
import com.chocolate.triviatitans.presentation.screens.quiz_screen.viewModel.multi_choice.MultiChoiceTextUiState
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
            LazyColumn {
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