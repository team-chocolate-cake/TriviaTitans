package com.chocolate.triviatitans.presentation.screens.quiz_screen.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.chocolate.triviatitans.presentation.theme.Primary

@Composable
fun AnswerLetterCard(textColor: Color) {
    Box(
        modifier = Modifier.border(
            width = 1.dp,
            color = Primary,
            shape = RoundedCornerShape(size = 8.dp)
        )

    ) {
        Text(
            text = "A", modifier = Modifier
                .padding(horizontal = 8.dp, vertical = 12.dp),
            color = textColor
        )
    }
}