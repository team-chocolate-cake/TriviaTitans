package com.chocolate.triviatitans.presentation.screens.win_lose_screens.composable

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SpaceVertical(space: Int) {
    Spacer(modifier = Modifier.padding(vertical = space.dp))
}

@Composable
fun SpaceTop(space: Int) {
    Spacer(modifier = Modifier.padding(vertical = space.dp))
}

@Composable
fun SpaceHorizontal(space: Int) {
    Spacer(modifier = Modifier.padding(horizontal = space.dp))
}