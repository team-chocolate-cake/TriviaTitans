package com.chocolate.triviatitans.presentation.screens.quiz_screen.word_wise

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.chocolate.triviatitans.presentation.screens.quiz_screen.listener.AnswerCardListener
import com.chocolate.triviatitans.presentation.screens.quiz_screen.listener.HintListener
import com.chocolate.triviatitans.presentation.screens.quiz_screen.word_wise.view_model.WordWiseUIState
import com.chocolate.triviatitans.presentation.screens.quiz_screen.word_wise.view_model.WordWiseViewModel

@Composable
fun WordWiseScreen(navController: NavController) {


    val wordWiseViewModel: WordWiseViewModel = hiltViewModel()
    val wordWiseState = wordWiseViewModel.state.collectAsState().value

    //  TODO() navController.navigateToLose()
    //  TODO()  navController.navigateToSpinWheelScreen()

//    WordWiseContent(
//        multiChoiceTextUiState = quizScreenState,
//        quizScreenViewModel,
//        gameType = quizScreenViewModel.gameTypeArgs.toString().toInt(),
//        quizScreenViewModel,
//        quizScreenState.isButtonsEnabled,
//        wordWiseState,
//        wordWiseViewModel::onLetterClicked
//
//    )
//    Log.d(
//        "level_type",
//        "${quizScreenViewModel.gameTypeArgs}+${quizScreenViewModel.categoriesArgs}+${quizScreenViewModel.levelTypeArgs}"
//    )
}

@Composable
fun WordWiseContent(
    answerCardListener: AnswerCardListener,
    gameType: Int,
    hintListener: HintListener,
    isButtonsEnabled: Boolean,
    wordWiseState: WordWiseUIState,
    onLetterClick: (Char) -> Unit,
) {
//    Column(
//        Modifier
//            .fillMaxSize()
//            .background(color = MaterialTheme.customColor().background)
//            .padding(horizontal = 16.dp, vertical = 16.dp)
//    ) {
//        if (multiChoiceTextUiState.questionUiStates.isNotEmpty()) {
//            val currentQuestion = multiChoiceTextUiState
//                .questionUiStates[multiChoiceTextUiState.questionNumber]
//            Header(
//                hintListener = hintListener,
//                fiftyHint = multiChoiceTextUiState.hintFiftyFifty,
//                heartHint = multiChoiceTextUiState.hintHeart,
//                resetHint = multiChoiceTextUiState.hintReset,
//                questionNumber = multiChoiceTextUiState.questionNumber + 1,
//                multiChoiceTextUiState.userScore,
//                correctAnswer = currentQuestion.correctAnswer
//            )
//            SpacerVertical16()
//            AnswersSection(
//                answerCardListener,
//                gameType = gameType,
//                question = currentQuestion,
//                questionNumber = multiChoiceTextUiState.questionNumber,
//                isButtonsEnabled = isButtonsEnabled,
//                multiChoiceTextUiState = multiChoiceTextUiState,
//                wordWiseUIState = wordWiseState,
//                onLetterClick = onLetterClick
//            )
//        }
//    }
}
