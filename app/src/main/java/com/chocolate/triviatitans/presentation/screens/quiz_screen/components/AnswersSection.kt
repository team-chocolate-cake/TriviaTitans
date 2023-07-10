package com.chocolate.triviatitans.presentation.screens.quiz_screen.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import com.chocolate.triviatitans.composables.SpacerVertical8
import com.chocolate.triviatitans.presentation.screens.GameType
import com.chocolate.triviatitans.presentation.screens.quiz_screen.listener.AnswerCardListener
import com.chocolate.triviatitans.presentation.screens.quiz_screen.viewModel.MultiChoiceTextUiState

@Composable
fun AnswersSection(
    answerCardListener: AnswerCardListener,
    gameType: Int = GameType.MULTI_CHOICE_IMAGES.ordinal,
    question: MultiChoiceTextUiState.QuestionUiState,
    questionNumber: Int,
    isButtonsEnabled: Boolean,
    state: MultiChoiceTextUiState,
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
                state = state,
                question = question,
                answerCardListener = answerCardListener,
                isButtonsEnabled = isButtonsEnabled
            )
        }

        GameType.WORD_WISE.ordinal -> {}

    }
}

//@Preview(showSystemUi = true)
//@Composable
//fun AnswersSectionPreview() {
//    AnswersSection(
//        answerCardListener = object : AnswerCardListener {
//            override fun onClickCard(
//                question: String,
//                questionNumber: Int,
//                isCorrectAnswer: Boolean
//            ) {
//                TODO("Not yet implemented")
//            }
//
//            override fun updateButtonState(value: Boolean) {
//                TODO("Not yet implemented")
//            }
//
//
//        },
//        question = MultiChoiceTextUiState.QuestionUiState(id = ""),
//        questionNumber = 0,
//        isButtonsEnabled = true,
//        state = null,
//    )
//}
