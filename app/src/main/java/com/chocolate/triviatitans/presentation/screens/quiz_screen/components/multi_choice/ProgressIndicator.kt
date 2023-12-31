package com.chocolate.triviatitans.presentation.screens.quiz_screen.components.multi_choice

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chocolate.triviatitans.presentation.theme.customColor

@Composable
fun ProgressIndicator(progressPercentage: Float, modifier: Modifier = Modifier) {
    val timer by animateFloatAsState(targetValue = progressPercentage)

    val progressAnimDuration = 1500

    val color by animateColorAsState(
        when (timer) {
            in 0.7f..1f -> Color(MaterialTheme.customColor().correct.value)
            in 0.4f..0.7f -> Color(MaterialTheme.customColor().gameOver.value)
            else -> Color(MaterialTheme.customColor().error.value)
        },
        tween(durationMillis = progressAnimDuration, easing = FastOutSlowInEasing)
    )
    Box(Modifier.clip(RoundedCornerShape(4.dp))) {
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(8.dp)
                .background(Color.White)
        )
        Spacer(
            modifier = Modifier
                .fillMaxWidth(timer)
                .height(8.dp)
                .background(color)
        )
    }
}

@Preview
@Composable
fun ProgressIndicatorPreview() {
    ProgressIndicator(.7f)
}