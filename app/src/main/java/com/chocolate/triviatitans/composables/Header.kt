package com.chocolate.triviatitans.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.chocolate.triviatitans.presentation.screens.quiz_screen.HintButton
import com.chocolate.triviatitans.presentation.screens.quiz_screen.components.multi_choice.PlayerGameAppBarInfo
import com.chocolate.triviatitans.presentation.screens.quiz_screen.components.multi_choice.ProgressIndicator
import com.chocolate.triviatitans.presentation.screens.quiz_screen.components.multi_choice.QuestionHintsSection
import com.chocolate.triviatitans.presentation.screens.quiz_screen.listener.HintListener
import com.chocolate.triviatitans.presentation.theme.TriviaTitansTheme

@Composable
fun Header(
    hintListener: HintListener,
    fiftyHint: HintButton,
    heartHint: HintButton,
    skipHint: HintButton,
    questionNumber: Int,
    userScore: Int,
    correctAnswer: String,
    timerProgress:Float,
    levelType:String,
    typeGame:String = "defaultGame"
) {
    Column {
        PlayerGameAppBarInfo(questionNumber, userScore,levelType)
        SpacerVertical16()
        QuestionHintsSection(
            hintListener = hintListener, fiftyHint,
            heartHint,
            skipHint,
            correctAnswer,
            isImageGame = typeGame != "defaultGame"
        )
        SpacerVertical16()
        ProgressIndicator(progressPercentage = timerProgress)
    }
}

@Preview(showSystemUi = true)
@Composable
fun HeaderPreview() {
    TriviaTitansTheme() {
        Header(
            hintListener = object : HintListener {
                override fun onClickFiftyFifty() {
                    TODO("Not yet implemented")
                }

                override fun onClickHeart() {
                    TODO("Not yet implemented")
                }

                override fun onClickSkip() {
                    TODO("Not yet implemented")
                }
            }, HintButton(), HintButton(),
            HintButton(), questionNumber = 3, userScore = 0, "",1f,
            "Easy Type"
        )
    }
}

