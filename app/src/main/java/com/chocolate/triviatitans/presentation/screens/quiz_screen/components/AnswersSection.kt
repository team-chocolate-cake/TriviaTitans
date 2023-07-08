package com.chocolate.triviatitans.presentation.screens.quiz_screen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chocolate.triviatitans.presentation.screens.GameType
import com.chocolate.triviatitans.presentation.screens.quiz_screen.AnswerCardListener
import com.chocolate.triviatitans.presentation.screens.quiz_screen.viewModel.MultiChoiceTextUiState

@Composable
fun AnswersSection(
    answerCardListener: AnswerCardListener,
    gameType: String = "Multi_Choice",
    question: MultiChoiceTextUiState.QuestionUiState,
    questionNumber: Int,
    isButtonsEnabled: Boolean
) {

    val givenQuestion = question.randomAnswers
    when (gameType) {
        GameType.Multi_Choice.name -> {
            Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                AnswerCard(
                    'A',
                    givenQuestion[0],
                    answerCardListener,
                    questionNumber,
                    question.correctAnswer,
                    isButtonsEnabled
                )
                AnswerCard(
                    'B',
                    givenQuestion[1],
                    answerCardListener,
                    questionNumber,
                    question.correctAnswer,
                    isButtonsEnabled
                )
                AnswerCard(
                    'C',
                    givenQuestion[2],
                    answerCardListener,
                    questionNumber,
                    question.correctAnswer,
                    isButtonsEnabled
                )
                AnswerCard(
                    'D',
                    givenQuestion[3],
                    answerCardListener,
                    questionNumber,
                    question.correctAnswer,
                    isButtonsEnabled
                )
            }
        }

        GameType.Multi_Choice_Images.name -> {
            MultiChoiceImagesGame()
        }

        GameType.Word_Wise.name -> {}

    }
}

@Preview(showSystemUi = true)
@Composable
fun AnswersSectionPreview() {
    AnswersSection(
        answerCardListener = object : AnswerCardListener {
            override fun onClickCard(question: String, questionNumber: Int) {
                TODO("Not yet implemented")
            }

            override fun updateButtonState(value: Boolean) {
                TODO("Not yet implemented")
            }


        },
        question = MultiChoiceTextUiState.QuestionUiState(id = ""),
        questionNumber = 0,
        isButtonsEnabled = true
    )
}
