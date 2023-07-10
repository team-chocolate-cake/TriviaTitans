package com.chocolate.triviatitans.ui.screens.level.compose

import androidx.compose.runtime.Composable
import com.chocolate.triviatitans.presentation.theme.CustomColorsPalette

@Composable
fun DescriptionLevel(color: CustomColorsPalette) {
    TitleText(color = color)
    SubTitleText(color = color)
}