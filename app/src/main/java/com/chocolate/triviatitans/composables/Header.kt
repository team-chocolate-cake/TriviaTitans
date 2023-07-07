package com.chocolate.triviatitans.presentation.screens.quiz_screen.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.chocolate.triviatitans.composables.SpacerVertical16
import com.chocolate.triviatitans.composables.SpacerVertical32
import com.chocolate.triviatitans.presentation.theme.TriviaCustomColors
import com.chocolate.triviatitans.presentation.theme.TriviaTitansTheme

@Composable
fun Header() {
    Column {
        PlayerDashBoard()
        SpacerVertical16()
        QuestionHintsSection()
        SpacerVertical16()
        ProgressIndicator(progressPercentage = .6f)
        SpacerVertical32()
        Text(
            text = "What sport is best known as the ‘king of sports ?",
            style = MaterialTheme.typography.titleMedium,
            color = TriviaCustomColors.current.onBackground87
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun HeaderPreview() {
    TriviaTitansTheme() { Header() }
}

