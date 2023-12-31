package com.chocolate.triviatitans.presentation.screens.quiz_screen.word_wise.components.word_wise

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chocolate.triviatitans.presentation.theme.TriviaCustomColors

@Composable
fun AnswerTextCard(
    text: Char,
    onAnswerCardClicked: () -> Unit,
) {
    val isFilled = remember { mutableStateOf(false) }

    isFilled.value = (text != ' ')

    if (isFilled.value) {
        TextCard(
            text = text.toString(),
            textColor = TriviaCustomColors.current.secondary,
            modifier = Modifier
                .background(
                    TriviaCustomColors.current.primary,
                    shape = RoundedCornerShape(size = 12.dp)

                )
                .clickable {
                    isFilled.value != isFilled.value
                    onAnswerCardClicked()
                }

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
fun AnswerTextCardPreview() {
    AnswerTextCard(text = 'A', onAnswerCardClicked = {})
}
