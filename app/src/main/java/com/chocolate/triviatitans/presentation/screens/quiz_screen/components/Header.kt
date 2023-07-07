package com.chocolate.triviatitans.presentation.screens.quiz_screen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chocolate.triviatitans.R

@Composable
fun Header() {
    Column() {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(PaddingValues(horizontal = 16.dp))
        ) {
            NumberOfQuestions(maxQuestionsNumber = 10, questionNumber = 1)
            Text(
                text = "Easy Level",
                style = MaterialTheme.typography.titleMedium,
                textAlign = TextAlign.Center,
            )
            TotalBounce(bounce = 500)
        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(PaddingValues(horizontal = 28.dp, vertical = 16.dp))
        ) {
            QuestionHint(icon = R.drawable.ic_50_50, numberOfTries = 2)
            QuestionHint(icon = R.drawable.ic_heart, numberOfTries = 2)
            QuestionHint(icon = R.drawable.ic_restart, numberOfTries = 2)
        }

    }
}

@Preview(showSystemUi = true)
@Composable
fun HeaderPreview() {
    Header()
}

