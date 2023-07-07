package com.chocolate.triviatitans.presentation.screens.quiz_screen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chocolate.triviatitans.R
import com.chocolate.triviatitans.presentation.theme.TriviaTitansTheme

@Composable
fun QuestionHintsSection() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        QuestionHint(
            icon = R.drawable.ic_50_50,
            numberOfTries = 2,
            imageModifier = Modifier.padding(16.dp)
        )
        QuestionHint(
            icon = R.drawable.ic_heart,
            numberOfTries = 2,
            imageModifier = Modifier.padding(20.dp)
        )
        QuestionHint(
            icon = R.drawable.ic_restart,
            numberOfTries = 2,
            imageModifier = Modifier.padding(20.dp)
        )
    }
}
@Preview(showSystemUi = true)
@Composable
fun QuestionHintsSectionPreview() {
    TriviaTitansTheme() {
        QuestionHintsSection()
    }
}