package com.chocolate.triviatitans.ui.screens.level.compose

import androidx.compose.runtime.Composable

@Composable
fun LevelImage() {
    Image(
        painter = painterResource(id = R.drawable.level_image),
        contentDescription = "Level Image",
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp)
    )
}