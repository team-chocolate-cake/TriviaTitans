package com.chocolate.triviatitans.presentation.screens.quiz_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chocolate.triviatitans.presentation.screens.quiz_screen.components.AnswersSection
import com.chocolate.triviatitans.presentation.screens.quiz_screen.components.Header
import com.chocolate.triviatitans.presentation.screens.quiz_screen.components.ProgressIndicator

@Composable
fun QuizScreen() {
    Column(Modifier.padding(horizontal = 16.dp)) {
        Header()
        ProgressIndicator(progressPercentage = .6f)
        Text(
            text = "What sport is best known as the ‘king of sports ?",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(top = 16.dp, bottom = 24.dp)
        )
        AnswersSection()
    }

}

@Preview(showSystemUi = true)
@Composable
fun QuizScreenPreview() {
    QuizScreen()
}

