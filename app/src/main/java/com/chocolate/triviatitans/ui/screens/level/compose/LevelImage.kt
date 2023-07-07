package com.chocolate.triviatitans.ui.screens.level.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.chocolate.triviatitans.R

@Composable
fun LevelImage() {
    Image(
        painter = painterResource(id = R.drawable.level_image),
        contentDescription = "Level Image",
        modifier = Modifier
            .fillMaxWidth()
    )
}