package com.chocolate.triviatitans.presentation.screens.quiz_screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.chocolate.triviatitans.R
import com.chocolate.triviatitans.presentation.theme.TriviaCustomColors

@Composable
fun TotalBounce(bounce: Int) {
        Row() {
            Text(text = bounce.toString(),color = TriviaCustomColors.current.onBackground87)
            SpacerHorizontal4Dp()
            Image(painter = painterResource(id = R.drawable.ic_score), contentDescription = "icon score")
        }
}

@Preview
@Composable
fun TotalBouncePreview() {
    TotalBounce(500)
}