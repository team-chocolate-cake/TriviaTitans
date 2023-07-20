package com.chocolate.triviatitans.presentation.screens.quiz_screen.components.multi_choice

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
import com.chocolate.triviatitans.presentation.theme.customColor

@Composable
fun PlayerGameAppBarInfo(questionNumber: Int, bounce: Int,levelType:String) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        NumberOfQuestions(maxQuestionsNumber = 10, questionNumber = questionNumber)
        Text(
            text = levelType,
            style = MaterialTheme.typography.titleMedium,
            textAlign = TextAlign.Center,
            color = MaterialTheme.customColor().onBackground87
        )
        TotalBounce(bounce = bounce)
    }
}

@Preview(showBackground = true)
@Composable
fun PlayerDashBoardPreview() {
    TriviaTitansTheme() {
        PlayerGameAppBarInfo(3, 0,"Easy level")
    }
}