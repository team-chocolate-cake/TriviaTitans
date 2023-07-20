package com.chocolate.triviatitans.presentation.screens.quiz_screen.word_wise

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import com.chocolate.triviatitans.R
import com.chocolate.triviatitans.composables.Header
import com.chocolate.triviatitans.presentation.screens.home.navigateToHome
import com.chocolate.triviatitans.presentation.screens.lose.navigateToLose
import com.chocolate.triviatitans.presentation.screens.quiz_screen.listener.HintListener
import com.chocolate.triviatitans.presentation.screens.quiz_screen.word_wise.components.word_wise.AnswerLettersLazyGrid
import com.chocolate.triviatitans.presentation.screens.quiz_screen.word_wise.components.word_wise.BackPressSample
import com.chocolate.triviatitans.presentation.screens.quiz_screen.word_wise.components.word_wise.ButtonConfirm
import com.chocolate.triviatitans.presentation.screens.quiz_screen.word_wise.components.word_wise.KeyboardLatterLazyGrid
import com.chocolate.triviatitans.presentation.screens.quiz_screen.word_wise.view_model.WordWiseUIState
import com.chocolate.triviatitans.presentation.screens.quiz_screen.word_wise.view_model.WordWiseViewModel
import com.chocolate.triviatitans.presentation.screens.spinWheel.navigateToSpinWheelScreen
import com.chocolate.triviatitans.presentation.theme.customColor

@Composable
fun WordWiseScreen(navController: NavController) {


    val viewModel: WordWiseViewModel = hiltViewModel()
    val state = viewModel.state.collectAsState().value
    val context = LocalContext.current

    LaunchedEffect(key1 = state.didUserWin) {
        when (state.didUserWin) {
            true -> navController.navigateToSpinWheelScreen()
            false -> navController.navigateToLose()
            else -> {}
        }
    }

    WordWiseContent(
        state = state,
        onLetterClick = viewModel::onLetterClicked,
        onAnswerCardClicked = viewModel::onAnswerCardClicked,
        onClickConfirm = { viewModel.onClickConfirm(context) },
        onBackToLevel = { navController.navigateToHome() },
        hintListener = viewModel,
        viewModel = viewModel,
    )
}

@Composable
fun WordWiseContent(
    state: WordWiseUIState,
    onLetterClick: (Char) -> Unit,
    onAnswerCardClicked: (Int) -> Unit,
    onClickConfirm: () -> Unit,
    onBackToLevel: () -> Unit,
    hintListener: HintListener,
    viewModel: WordWiseViewModel
) {
    if (state.questionUiStates.isNotEmpty()) {
        BackPressSample(onBackToLevel)

        LaunchedEffect(true) {
            viewModel.updateTimer()

        }
        LaunchedEffect(state.questionNumber) {
            viewModel.progressTimer.value = 1f
        }
        Column(Modifier.padding(horizontal = 16.dp)) {
            Header(
                hintListener = hintListener,
                fiftyHint = state.hintFiftyFifty,
                heartHint = state.hintHeart,
                skipHint = state.hintSkip,
                questionNumber = state.questionNumber + 1,
                userScore = state.userScore,
                correctAnswer = state.questionUiStates[state.questionNumber].correctAnswer,
                timerProgress = state.timer,
                levelType = viewModel.levelType
            )
            Text(
                modifier = Modifier.padding(top = 32.dp),
                text = state.questionUiStates[state.questionNumber].question,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.customColor().onBackground87
            )

            AnswerLettersLazyGrid(
                charsList = state
                    .questionUiStates[state.questionNumber].correctAnswerLetters,
                selectedLetterList = state.selectedLetterList,
                onAnswerCardClicked = onAnswerCardClicked,
                modifier = Modifier.padding(top = 16.dp)
            )
            KeyboardLatterLazyGrid(
                charsList = state.keyboardLetters,
                onLetterClick = onLetterClick
            )
            Spacer(modifier = Modifier.fillMaxHeight(0.6f))
            ButtonConfirm(
                onClickConfirm = onClickConfirm,
                modifier = Modifier.padding(bottom = 16.dp)
            )
        }
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
