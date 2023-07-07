package com.chocolate.triviatitans.presentation.screens.quiz_screen.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chocolate.triviatitans.R

@Composable
fun QuestionHint(@DrawableRes icon: Int, numberOfTries: Int) {
    Box(modifier = Modifier.size(64.dp), contentAlignment = Alignment.BottomEnd) {
        Image(
            painter = painterResource(id = icon),
            contentDescription = "question help",
            modifier = Modifier
                .padding(PaddingValues(16.dp))
                .fillMaxSize()
                .drawBehind {
                    drawCircle(
                        color = Color(0xFF483081),
                        radius = this.size.maxDimension
                    )
                }
                .align(Alignment.Center)
        )
        Text(
            color = Color(0xFF483081),
            modifier = Modifier
                .padding(PaddingValues(4.dp))
                .drawBehind {
                    drawCircle(
                        color = Color(0xFFE4D3FF),
                        radius = 20f
                    )
                },
            text = numberOfTries.toString(),
            style = MaterialTheme.typography.bodySmall
        )
    }
}

@Preview
@Composable
fun QuestionHintPreview() {
    QuestionHint(icon = R.drawable.ic_heart, 3)
}