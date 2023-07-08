package com.chocolate.triviatitans.presentation.screens.quiz_screen.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.chocolate.triviatitans.composables.SpacerVertical8
import com.chocolate.triviatitans.presentation.screens.GameType
import com.chocolate.triviatitans.presentation.screens.quiz_screen.listener.AnswerCardListener
import com.chocolate.triviatitans.presentation.screens.quiz_screen.viewModel.MultiChoiceTextUiState

@Composable
fun AnswersSection(
    answerCardListener: AnswerCardListener,
    gameType: String = GameType.Multi_Choice_Images.name,
    question: MultiChoiceTextUiState.QuestionUiState,
    questionNumber: Int,
    isButtonsEnabled: Boolean,
    state : MultiChoiceTextUiState,
) {
    val givenQuestion = question.randomAnswers

    when (gameType) {
        GameType.Multi_Choice.name -> {
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

        GameType.Multi_Choice_Images.name -> {
            MultiChoiceImagesGame(state = state , question = question , answerCardListener = answerCardListener ,)
        }

        GameType.Word_Wise.name -> {}

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
