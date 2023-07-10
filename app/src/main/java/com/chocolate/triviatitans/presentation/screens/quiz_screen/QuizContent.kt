package com.chocolate.triviatitans.presentation.screens.quiz_screen

import android.util.Log
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
import androidx.navigation.NavHostController
import com.chocolate.triviatitans.composables.Header
import com.chocolate.triviatitans.composables.SpacerVertical16
import com.chocolate.triviatitans.presentation.screens.quiz_screen.components.AnswersSection
import com.chocolate.triviatitans.presentation.screens.quiz_screen.listener.AnswerCardListener
import com.chocolate.triviatitans.presentation.screens.quiz_screen.listener.HintListener
import com.chocolate.triviatitans.presentation.screens.quiz_screen.viewModel.MultiChoiceTextUiState
import com.chocolate.triviatitans.presentation.screens.quiz_screen.viewModel.QuizScreenViewModel
import com.chocolate.triviatitans.presentation.theme.TriviaCustomColors

@Composable
fun QuizScreen(navController: NavHostController) {
    val quizScreenViewModel: QuizScreenViewModel = hiltViewModel()
    val quizScreenState = quizScreenViewModel.state.collectAsState().value

    QuizContent(
        multiChoiceTextUiState = quizScreenState,
        quizScreenViewModel,
        gameType = quizScreenViewModel.gameTypeArgs.toString().toInt(),
        quizScreenViewModel,
        quizScreenState.isButtonsEnabled
    )
    Log.d(
        "level_type",
        "${quizScreenViewModel.gameTypeArgs}+${quizScreenViewModel.categoriesArgs}+${quizScreenViewModel.levelTypeArgs}"
    )
}

@Composable
fun QuizContent(
    multiChoiceTextUiState: MultiChoiceTextUiState,
    answerCardListener: AnswerCardListener,
    gameType: Int,
    hintListener: HintListener,
    isButtonsEnabled: Boolean
) {
    Column(
        Modifier
            .fillMaxSize()
            .background(color = TriviaCustomColors.current.background)
            .padding(horizontal = 16.dp, vertical = 16.dp)
    ) {
        if (multiChoiceTextUiState.questionUiStates.isNotEmpty()) {
            val currentQuestion = multiChoiceTextUiState
                .questionUiStates[multiChoiceTextUiState.questionNumber]
            Header(
                question = currentQuestion.question,
                hintListener = hintListener,
                fiftyHint = multiChoiceTextUiState.hintFiftyFifty,
                heartHint = multiChoiceTextUiState.hintHeart,
                resetHint = multiChoiceTextUiState.hintReset,
                questionNumber = multiChoiceTextUiState.questionNumber + 1,
                multiChoiceTextUiState.userScore,
                correctAnswer = currentQuestion.correctAnswer
            )
            SpacerVertical16()
            AnswersSection(
                answerCardListener,
                gameType = gameType,
                question = currentQuestion,
                questionNumber = multiChoiceTextUiState.questionNumber,
                isButtonsEnabled = isButtonsEnabled,
                state = multiChoiceTextUiState,
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun QuizScreenPreview() {
    /* TriviaTitansTheme() {
         QuizContent(MultiChoiceTextUiState(), object : AnswerCardListener {
             override fun onClickCard(
                 question: String,
                 questionNumber: Int,
                 isCorrectAnswer: Boolean
             ) {
                 TODO("Not yet implemented")
             }


             override fun updateButtonState(value: Boolean) {
                 TODO("Not yet implemented")
             }
         }, isButtonsEnabled = true, hintListener = object : HintListener {
             override fun onClickFiftyFifty() {
                 TODO("Not yet implemented")
             }

             override fun onClickHeart() {
                 TODO("Not yet implemented")
             }

             override fun onClickReset() {
                 TODO("Not yet implemented")
             }
         }, gameType = 0)
     }*/
}

