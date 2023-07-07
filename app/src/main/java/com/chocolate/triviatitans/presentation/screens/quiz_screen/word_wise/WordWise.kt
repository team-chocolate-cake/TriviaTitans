package com.chocolate.triviatitans.presentation.screens.quiz_screen.word_wise

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chocolate.triviatitans.presentation.screens.quiz_screen.components.AnswerLetterCard
import com.chocolate.triviatitans.presentation.screens.quiz_screen.components.Header
import com.chocolate.triviatitans.presentation.screens.quiz_screen.components.ProgressIndicator
import com.chocolate.triviatitans.presentation.theme.Primary

@Preview(showSystemUi = true)
@Composable
fun WordWise() {
    Column(Modifier.padding(horizontal = 16.dp)) {
        Header()
        ProgressIndicator(progressPercentage = .6f)
        Text(
            text = "What sport is best known as the ‘king of sports ?",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(top = 16.dp, bottom = 24.dp)
        )


    }
}
