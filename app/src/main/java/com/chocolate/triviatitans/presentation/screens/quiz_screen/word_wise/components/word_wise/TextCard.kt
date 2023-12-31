package com.chocolate.triviatitans.presentation.screens.quiz_screen.word_wise.components.word_wise

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chocolate.triviatitans.presentation.theme.Primary

@Composable
fun TextCard(
    text: String,
    modifier: Modifier = Modifier,
    textColor: Color,
) {
    Box(
        modifier = modifier
            .border(
                width = 1.dp,
                color = Primary,
                shape = RoundedCornerShape(size = 8.dp)
            )

    ) {
        Text(
            text = text, modifier = Modifier
                .padding(horizontal = 8.dp, vertical = 12.dp),
            textAlign = TextAlign.Center,
            color = textColor
        )
    }
}

@Preview
@Composable
fun TextCardPreview() {
    TextCard(text = "A", textColor = Color.White)
}