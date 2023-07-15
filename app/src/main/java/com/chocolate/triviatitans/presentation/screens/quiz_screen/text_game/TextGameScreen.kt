package com.chocolate.triviatitans.presentation.screens.quiz_screen.text_game

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.chocolate.triviatitans.composables.Header
import com.chocolate.triviatitans.composables.SpacerVertical16
import com.chocolate.triviatitans.composables.SpacerVertical32
import com.chocolate.triviatitans.composables.SpacerVertical8
import com.chocolate.triviatitans.presentation.screens.quiz_screen.text_game.components.AnswerCard
import com.chocolate.triviatitans.presentation.screens.quiz_screen.listener.AnswerCardListener
import com.chocolate.triviatitans.presentation.screens.quiz_screen.listener.HintListener
import com.chocolate.triviatitans.presentation.screens.quiz_screen.text_game.view_model.TextGameUiState
import com.chocolate.triviatitans.presentation.screens.quiz_screen.text_game.view_model.TextGameViewModel
import com.chocolate.triviatitans.presentation.theme.TriviaCustomColors
import com.chocolate.triviatitans.presentation.theme.TriviaTitansTheme


@Composable
fun TextGameScreen(
    viewModel: TextGameViewModel = hiltViewModel()
) {
    val state = viewModel.state.collectAsState().value

    TextGameContent(
        state = state,
        listener = viewModel,
        hintListener = viewModel,
    )

}

@Composable
fun TextGameContent(
    state: TextGameUiState,
    listener: AnswerCardListener,
    hintListener: HintListener,
) {
    Column(
        Modifier
            .fillMaxSize()
            .background(color = TriviaCustomColors.current.background)
            .padding(horizontal = 16.dp, vertical = 16.dp)
    ) {

        if (state.questionUiStates.isNotEmpty()) {
            val currentQuestion = state
                .questionUiStates[state.questionNumber]
            val question = currentQuestion.randomAnswers

            Header(
                hintListener = hintListener,
                fiftyHint = state.hintFiftyFifty,
                heartHint = state.hintHeart,
                resetHint = state.hintReset,
                questionNumber = state.questionNumber + 1,
                userScore = state.userScore,
                correctAnswer = currentQuestion.correctAnswer
            )
            SpacerVertical32()
            Text(
                text = currentQuestion.question,
                style = MaterialTheme.typography.titleMedium,
                color = TriviaCustomColors.current.onBackground87
            )
            SpacerVertical16()
            LazyColumn {
                itemsIndexed(question) { index, answer ->
                    AnswerCard(
                        answerAlphabet = 'A' + index,
                        answer = answer,
                        answerCardListener = listener,
                        questionNumber = state.questionNumber,
                        correctAnswer = currentQuestion.correctAnswer,
                        isButtonsEnabled = state.isButtonsEnabled,
                    )
                    SpacerVertical8()
                }
            }
        }
    }
}


@Preview
@Composable
fun TextGameScreenPreview() {
    TriviaTitansTheme {
        TextGameScreen()
    }
}