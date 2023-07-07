package com.chocolate.triviatitans.ui.screens.level.compose

@Composable
fun CardLevels(color: CustomColorsPalette) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(
            8.dp,
            alignment = Alignment.CenterHorizontally
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 40.dp, end = 40.dp, bottom = 32.dp)
    ) {
        ItemLevel(color = color, text = "Easy", backgroundColor = color.onSecondary)
        ItemLevel(color = color, text = "Medium", backgroundColor = color.primary)
        ItemLevel(color = color, text = "Hard", backgroundColor = color.onSecondary)
    }
}