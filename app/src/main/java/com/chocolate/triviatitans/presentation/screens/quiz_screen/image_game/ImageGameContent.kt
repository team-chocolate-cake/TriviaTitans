package com.chocolate.triviatitans.presentation.screens.quiz_screen.image_game

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import com.chocolate.triviatitans.R
import com.chocolate.triviatitans.composables.Header
import com.chocolate.triviatitans.composables.SpacerVertical16
import com.chocolate.triviatitans.composables.SpacerVertical32
import com.chocolate.triviatitans.presentation.screens.lose.navigateToLose
import com.chocolate.triviatitans.presentation.screens.quiz_screen.base.BaseQuizUiState
import com.chocolate.triviatitans.presentation.screens.quiz_screen.image_game.components.MultiChoiceImagesGame
import com.chocolate.triviatitans.presentation.screens.quiz_screen.image_game.view_model.ImageGameViewModel
import com.chocolate.triviatitans.presentation.screens.quiz_screen.listener.AnswerCardListener
import com.chocolate.triviatitans.presentation.screens.quiz_screen.listener.HintListener
import com.chocolate.triviatitans.presentation.screens.quiz_screen.word_wise.components.word_wise.BackPressSample
import com.chocolate.triviatitans.presentation.screens.spinWheel.navigateToSpinWheelScreen
import com.chocolate.triviatitans.presentation.theme.customColor

@Composable
fun ImageGameScreen(
    viewModel: ImageGameViewModel = hiltViewModel(),
    navController: NavController
) {
    val state = viewModel.state.collectAsState().value

    LaunchedEffect(key1 = state.didPlayerWin) {
        when (state.didPlayerWin) {
            true -> navController.navigateToSpinWheelScreen()
            false -> navController.navigateToLose()
            else -> {}
        }
    }
    ImageGameContent(
        state = state,
        listener = viewModel,
        hintListener = viewModel,
        onBackToLevel = { navController.popBackStack() },
        isButtonsEnabled = state.isButtonsEnabled,
        viewModel = viewModel
    )

}

@Composable
fun ImageGameContent(
    state: BaseQuizUiState,
    listener: AnswerCardListener,
    hintListener: HintListener,
    onBackToLevel: () -> Unit,
    isButtonsEnabled: Boolean = true,
    viewModel: ImageGameViewModel
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

            BackPressSample(onBackToLevel)

            LaunchedEffect(true) {
                viewModel.updateTimer()

            }
            LaunchedEffect(state.questionNumber) {
                viewModel.progressTimer.value = 1f
            }

            Header(
                hintListener = hintListener,
                fiftyHint = state.hintFiftyFifty,
                heartHint = state.hintHeart,
                skipHint = state.hintSkip,
                questionNumber = state.questionNumber + 1,
                userScore = state.userScore,
                correctAnswer = currentQuestion.correctAnswer,
                typeGame = "imageGame",
                timerProgress = state.timer,
                levelType = state.levelType
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
        } else if (state.isLoading) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CircularProgressIndicator()
            }
        } else {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                val composition by rememberLottieComposition(
                    spec = LottieCompositionSpec.RawRes(resId = R.raw.animation_lkakuvv9)
                )

                LottieAnimation(
                    modifier = Modifier.size(size = 140.dp),
                    composition = composition,
                )

            }

        }
    }
}


