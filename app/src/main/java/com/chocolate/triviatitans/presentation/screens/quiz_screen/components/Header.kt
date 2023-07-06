package com.chocolate.triviatitans.presentation.screens.quiz_screen.components

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.chocolate.triviatitans.composables.SpacerVertical16
import com.chocolate.triviatitans.presentation.theme.TriviaTitansTheme

@Composable
fun Header() {
    Column {
        PlayerDashBoard()
        SpacerVertical16()
        QuestionHintsSection()
    }
}

@Preview(showSystemUi = true)
@Composable
fun HeaderPreview() {
    TriviaTitansTheme() { Header() }
}

