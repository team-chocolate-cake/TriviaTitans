package com.chocolate.triviatitans.presentation.screens.quiz_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chocolate.triviatitans.composables.SpacerVertical16
import com.chocolate.triviatitans.composables.SpacerVertical32
import com.chocolate.triviatitans.presentation.screens.quiz_screen.components.AnswersSection
import com.chocolate.triviatitans.presentation.screens.quiz_screen.components.Header
import com.chocolate.triviatitans.presentation.screens.quiz_screen.components.ProgressIndicator
import com.chocolate.triviatitans.presentation.theme.TriviaCustomColors
import com.chocolate.triviatitans.presentation.theme.TriviaTitansTheme

@Composable
fun QuizScreen() {
    Column(
        Modifier
            .fillMaxSize()
            .background(color = TriviaCustomColors.current.background)
            .padding(horizontal = 16.dp)
    ) {
        SpacerVertical16()
        Header()
        SpacerVertical16()
        ProgressIndicator(progressPercentage = .6f)
        SpacerVertical32()
        Text(
            text = "What sport is best known as the ‘king of sports ?",
            style = MaterialTheme.typography.titleMedium,
            color = TriviaCustomColors.current.onBackground87
        )
        SpacerVertical16()
        AnswersSection()
    }
}

@Preview(showSystemUi = true,)
@Composable
fun QuizScreenPreview() {
    TriviaTitansTheme() {
        QuizScreen()
    }
}

