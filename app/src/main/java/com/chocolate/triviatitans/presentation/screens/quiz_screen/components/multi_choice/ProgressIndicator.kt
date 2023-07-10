package com.chocolate.triviatitans.presentation.screens.quiz_screen.components.multi_choice

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ProgressIndicator(progressPercentage:Float,modifier: Modifier=Modifier) {
    Box(Modifier.clip(RoundedCornerShape(4.dp))){
        Spacer(modifier = Modifier.fillMaxWidth().height(8.dp).background(Color.White))
        Spacer(modifier = Modifier.fillMaxWidth(progressPercentage).height(8.dp).background(Color(0xFFF21B1B)))
    }
}

@Preview
@Composable
fun ProgressIndicatorPreview() {
    ProgressIndicator(.5f)
}