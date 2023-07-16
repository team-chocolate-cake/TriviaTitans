package com.chocolate.triviatitans.presentation.screens.quiz_screen

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.chocolate.triviatitans.composables.Header
import com.chocolate.triviatitans.composables.SpacerVertical16
import com.chocolate.triviatitans.presentation.screens.quiz_screen.components.multi_choice.AnswersSection
import com.chocolate.triviatitans.presentation.screens.quiz_screen.listener.AnswerCardListener
import com.chocolate.triviatitans.presentation.screens.quiz_screen.listener.HintListener
import com.chocolate.triviatitans.presentation.screens.quiz_screen.view_model.word_wise.WordWiseUIState
import com.chocolate.triviatitans.presentation.screens.quiz_screen.view_model.word_wise.WordWiseViewModel
import com.chocolate.triviatitans.presentation.screens.quiz_screen.view_model.multi_choice.MultiChoiceTextUiState
import com.chocolate.triviatitans.presentation.screens.quiz_screen.view_model.multi_choice.QuizScreenViewModel
import com.chocolate.triviatitans.presentation.theme.TriviaCustomColors

@Composable
fun QuizScreen(navController: NavController) {

    val quizScreenViewModel: QuizScreenViewModel = hiltViewModel()
    val quizScreenState = quizScreenViewModel.state.collectAsState().value
    val wordWiseViewModel: WordWiseViewModel = hiltViewModel()
    val wordWiseState = wordWiseViewModel.state.collectAsState().value

    //  TODO() navController.navigateToLose()
    //  TODO()  navController.navigateToSpinWheelScreen()

    QuizContent(
        multiChoiceTextUiState = quizScreenState,
        quizScreenViewModel,
        gameType = quizScreenViewModel.gameTypeArgs.toString().toInt(),
        quizScreenViewModel,
        quizScreenState.isButtonsEnabled,
        wordWiseState,
        wordWiseViewModel::onLetterClicked

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
    isButtonsEnabled: Boolean,
    wordWiseState: WordWiseUIState,
    onLetterClick: (Char) -> Unit,
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
                multiChoiceTextUiState = multiChoiceTextUiState,
                wordWiseUIState = wordWiseState,
                onLetterClick = onLetterClick
            )
        }
    }
}
