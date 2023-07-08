package com.chocolate.triviatitans.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.chocolate.triviatitans.presentation.screens.quiz_screen.components.PlayerGameAppBarInfo
import com.chocolate.triviatitans.presentation.screens.quiz_screen.components.ProgressIndicator
import com.chocolate.triviatitans.presentation.screens.quiz_screen.components.QuestionHintsSection
import com.chocolate.triviatitans.presentation.screens.quiz_screen.listener.HintListener
import com.chocolate.triviatitans.presentation.screens.quiz_screen.viewModel.MultiChoiceTextUiState
import com.chocolate.triviatitans.presentation.theme.TriviaCustomColors
import com.chocolate.triviatitans.presentation.theme.TriviaTitansTheme

@Composable
fun Header(
    question: String,
    hintListener: HintListener,
    fiftyHint: MultiChoiceTextUiState.HintButton,
    heartHint: MultiChoiceTextUiState.HintButton,
    resetHint: MultiChoiceTextUiState.HintButton,
    questionNumber: Int,
    userScore: Int,
    correctAnswer: String
) {
    Column {
        PlayerGameAppBarInfo(questionNumber, userScore)
        SpacerVertical16()
        QuestionHintsSection(
            hintListener = hintListener, fiftyHint,
            heartHint,
            resetHint,
            correctAnswer
        )
        SpacerVertical16()
        ProgressIndicator(progressPercentage = .6f)
        SpacerVertical32()
        Text(
            text = question,
            style = MaterialTheme.typography.titleMedium,
            color = TriviaCustomColors.current.onBackground87
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun HeaderPreview() {
    TriviaTitansTheme() {
        Header(
            "", hintListener = object : HintListener {
                override fun onClickFiftyFifty() {
                    TODO("Not yet implemented")
                }

                override fun onClickHeart() {
                    TODO("Not yet implemented")
                }

                override fun onClickReset() {
                    TODO("Not yet implemented")
                }
            }, MultiChoiceTextUiState.HintButton(), MultiChoiceTextUiState.HintButton(),
            MultiChoiceTextUiState.HintButton(), questionNumber = 3, userScore = 0, ""
        )
    }
}

