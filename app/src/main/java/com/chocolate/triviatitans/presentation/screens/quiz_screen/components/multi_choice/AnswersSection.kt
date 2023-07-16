package com.chocolate.triviatitans.presentation.screens.quiz_screen.components.multi_choice

import androidx.compose.runtime.Composable
import com.chocolate.triviatitans.presentation.screens.quiz_screen.GameType
import com.chocolate.triviatitans.presentation.screens.quiz_screen.components.word_wise.WordWiseGame
import com.chocolate.triviatitans.presentation.screens.quiz_screen.listener.AnswerCardListener
import com.chocolate.triviatitans.presentation.screens.quiz_screen.view_model.word_wise.WordWiseUIState
import com.chocolate.triviatitans.presentation.screens.quiz_screen.view_model.multi_choice.MultiChoiceTextUiState

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
           /* LazyColumn {
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
            }*/
        }

        GameType.MULTI_CHOICE_IMAGES.ordinal -> {
/*            MultiChoiceImagesGame(
                state = multiChoiceTextUiState,
                question = question,
                answerCardListener = answerCardListener,
                isButtonsEnabled = isButtonsEnabled
            )*/
        }

        GameType.WORD_WISE.ordinal -> {
            WordWiseGame(wordWiseUIState = wordWiseUIState, onLetterClick = onLetterClick)
        }
    }
}