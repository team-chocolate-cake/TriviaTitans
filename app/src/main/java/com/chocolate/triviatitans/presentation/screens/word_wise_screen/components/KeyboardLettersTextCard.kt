package com.chocolate.triviatitans.presentation.screens.word_wise_screen.components

import androidx.compose.foundation.clickable
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.chocolate.triviatitans.presentation.theme.TriviaCustomColors

@Composable
fun KeyboardLettersTextCard(
    text: Char,
    onClick: (Char) -> Unit,
) {
    TextCard(
        text = text.toString(),
        modifier = Modifier.clickable { onClick(text) },
        textColor = TriviaCustomColors.current.primary,
    )
}


@Preview
@Composable
fun KeyboardLettersTextCardPreview() {
    KeyboardLettersTextCard(text = 'A', onClick = {})
}
