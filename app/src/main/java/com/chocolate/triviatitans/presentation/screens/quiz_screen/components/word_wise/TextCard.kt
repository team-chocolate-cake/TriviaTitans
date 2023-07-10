package com.chocolate.triviatitans.presentation.screens.quiz_screen.components.word_wise

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
    onClick: (String) -> Unit = {},
    textColor: Color,
) {
    Box(
        modifier = modifier
            .clickable {
                onClick(text)
            }
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
    TextCard(text = "A", onClick = {}, textColor = Color.White)
}