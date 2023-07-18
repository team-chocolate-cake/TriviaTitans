package com.chocolate.triviatitans.presentation.screens.quiz_screen.image_game

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.chocolate.triviatitans.composables.Header
import com.chocolate.triviatitans.composables.SpacerVertical16
import com.chocolate.triviatitans.composables.SpacerVertical32
import com.chocolate.triviatitans.presentation.screens.quiz_screen.base.BaseQuizUiState
import com.chocolate.triviatitans.presentation.screens.quiz_screen.image_game.components.MultiChoiceImagesGame
import com.chocolate.triviatitans.presentation.screens.quiz_screen.image_game.view_model.ImageGameViewModel
import com.chocolate.triviatitans.presentation.screens.quiz_screen.listener.AnswerCardListener
import com.chocolate.triviatitans.presentation.screens.quiz_screen.listener.HintListener
import com.chocolate.triviatitans.presentation.theme.TriviaCustomColors
import com.chocolate.triviatitans.presentation.theme.customColor

@Composable
fun ImageGameScreen(
    viewModel: ImageGameViewModel = hiltViewModel(),
    navController: NavController
) {
    val state = viewModel.state.collectAsState().value



    ImageGameContent(
        state = state,
        listener = viewModel,
        hintListener = viewModel,
        isButtonsEnabled = state.isButtonsEnabled
    )

}

@Composable
fun ImageGameContent(
    state: BaseQuizUiState,
    listener: AnswerCardListener,
    hintListener: HintListener,
    isButtonsEnabled: Boolean = true
) {

    Column(
        Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.customColor().background)
            .padding(horizontal = 16.dp, vertical = 16.dp)
    ) {

        if (state.questionUiStates.isNotEmpty()) {
            val currentQuestion = state
                .questionUiStates[state.questionNumber]

            Header(
                hintListener = hintListener,
                fiftyHint = state.hintFiftyFifty,
                heartHint = state.hintHeart,
                resetHint = state.hintReset,
                questionNumber = state.questionNumber + 1,
                userScore = state.userScore,
                correctAnswer = currentQuestion.correctAnswer,
                state.timer

            )
            SpacerVertical32()
            Text(
                text = currentQuestion.question,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.customColor().onBackground87
            )
            SpacerVertical16()
            MultiChoiceImagesGame(
                state = state,
                question = currentQuestion,
                answerCardListener = listener,
                isButtonsEnabled = isButtonsEnabled
            )
        }
    }
}
