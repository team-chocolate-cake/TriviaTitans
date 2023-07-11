package com.chocolate.triviatitans.presentation.screens.word_wise_screen.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.chocolate.triviatitans.presentation.theme.TriviaCustomColors

@Composable
fun KeyboardLettersTextCard(
    text: Char,
    onClick: (Char) -> Unit,
) {
    TextCard(
        text = text.toString(),
        onClick = {
            onClick(text)
        },
        textColor = TriviaCustomColors.current.primary,
    )
}

