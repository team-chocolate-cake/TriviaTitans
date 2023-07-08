package com.chocolate.triviatitans.presentation.screens.word_wise_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chocolate.triviatitans.presentation.theme.TriviaCustomColors

@Composable
fun CorrectAnswerTextCard(
    text: Char,
    onClick: (Char) -> Unit = {},
) {
    val isFilled = remember { mutableStateOf(false) }

    isFilled.value = (text != ' ')

    if (isFilled.value) {
        TextCard(
            text = text.toString(),
            textColor = TriviaCustomColors.current.secondary,
            modifier = Modifier.background(
                TriviaCustomColors.current.primary,
                shape = RoundedCornerShape(size = 12.dp)
            )
        )
    } else {
        TextCard(
            text = text.toString(),
            textColor = TriviaCustomColors.current.primary,
        )
    }
}

@Preview
@Composable
fun CorrectAnswerTextCardPreview() {
    CorrectAnswerTextCard(text = 'A', onClick = {})
}