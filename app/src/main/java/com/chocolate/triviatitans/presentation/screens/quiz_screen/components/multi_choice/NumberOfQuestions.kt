package com.chocolate.triviatitans.presentation.screens.quiz_screen.components.multi_choice

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.chocolate.triviatitans.R
import com.chocolate.triviatitans.presentation.theme.TriviaCustomColors
import com.chocolate.triviatitans.presentation.theme.customColor

@Composable
fun NumberOfQuestions(maxQuestionsNumber: Int, questionNumber: Int) {
    Row {
        Text(
            text = "$questionNumber/$maxQuestionsNumber",
            style = MaterialTheme.typography.bodyMedium,
            color =  MaterialTheme.customColor().onBackground87
        )
        SpacerHorizontal4Dp()
        Image(painter = painterResource(id = R.drawable.ic_fire), contentDescription = "icon fire")
    }
}

@Preview
@Composable
fun NumberOfQuestionsPreview() {
    NumberOfQuestions(10, 1)
}