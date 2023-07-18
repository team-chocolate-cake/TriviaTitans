package com.chocolate.triviatitans.presentation.screens.quiz_screen.components.multi_choice

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chocolate.triviatitans.R
import com.chocolate.triviatitans.composables.ImageView
import com.chocolate.triviatitans.composables.SpacerHorizontal4
import com.chocolate.triviatitans.presentation.theme.TriviaCustomColors
import com.chocolate.triviatitans.presentation.theme.customColor

@Composable
fun TotalBounce(bounce: Int) {
    Row(verticalAlignment = Alignment.CenterVertically , horizontalArrangement = Arrangement.Center) {
        Text(text = bounce.toString(), color = MaterialTheme.customColor().onBackground87)
        SpacerHorizontal4()
        ImageView(ImageResource = R.drawable.ic_score, contentDescription = "icon score", modifier = Modifier.size(18.dp))
    }
}

@Preview
@Composable
fun TotalBouncePreview() {
    TotalBounce(500)
}