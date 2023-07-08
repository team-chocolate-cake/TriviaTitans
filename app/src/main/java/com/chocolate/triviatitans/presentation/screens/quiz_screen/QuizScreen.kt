package com.chocolate.triviatitans.presentation.screens.quiz_screen

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.chocolate.triviatitans.composables.SpacerVertical16
import com.chocolate.triviatitans.composables.SpacerVertical32
import com.chocolate.triviatitans.presentation.screens.quiz_screen.components.AnswersSection
import com.chocolate.triviatitans.presentation.screens.quiz_screen.components.Header
import com.chocolate.triviatitans.presentation.screens.quiz_screen.components.ProgressIndicator
import com.chocolate.triviatitans.presentation.screens.quiz_screen.viewModel.QuizScreenViewModel
import com.chocolate.triviatitans.presentation.screens.quiz_screen.viewModel.multi_choice_images_game.MultiChoiceImagesGameViewModel
import com.chocolate.triviatitans.presentation.theme.TriviaCustomColors
import com.chocolate.triviatitans.presentation.theme.TriviaTitansTheme

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun QuizScreen(
    viewModel: QuizScreenViewModel = hiltViewModel(),
    gameViewModel: MultiChoiceImagesGameViewModel = hiltViewModel(),
) {
    val state = gameViewModel.state.collectAsState().value

    Column(
        Modifier
            .fillMaxSize()
            .background(color = TriviaCustomColors.current.background)
            .padding(horizontal = 16.dp, vertical = 16.dp)
    ) {

        if (state.questions.isNotEmpty()) {
            Header()
            Text(
                text = state.questions[state.questionCount].question,
                style = MaterialTheme.typography.titleMedium,
                color = TriviaCustomColors.current.onBackground87
            )
            SpacerVertical16()
            AnswersSection(state)
        }
    }
}

@Preview(showSystemUi = true,)
@Composable
fun QuizScreenPreview() {
    TriviaTitansTheme() {
        QuizScreen()
    }
}

