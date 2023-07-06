package com.chocolate.triviatitans.presentation.screens.quiz_screen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.chocolate.triviatitans.presentation.theme.TriviaCustomColors
import com.chocolate.triviatitans.presentation.theme.TriviaTitansTheme

@Composable
fun PlayerDashBoard() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        NumberOfQuestions(maxQuestionsNumber = 10, questionNumber = 1)
        Text(
            text = "Easy Level",
            style = MaterialTheme.typography.titleMedium,
            textAlign = TextAlign.Center,
            color = TriviaCustomColors.current.onBackground87
        )
        TotalBounce(bounce = 500)
    }
}

@Preview(showBackground = true)
@Composable
fun PlayerDashBoardPreview() {
    TriviaTitansTheme() {
        PlayerDashBoard()
    }
}