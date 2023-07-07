package com.chocolate.triviatitans.ui.screens.level.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.chocolate.triviatitans.ui.theme.CustomColorsPalette
import com.chocolate.triviatitans.view_model.level.LevelUiState

@Composable
fun CardLevels(
    color: CustomColorsPalette,
    onLevelSelected: (String) -> Unit,
    state: LevelUiState
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(
            8.dp,
            alignment = Alignment.CenterHorizontally
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 40.dp, end = 40.dp, bottom = 32.dp)
    ) {
        ItemLevel(
            color = color,
            text = "Easy",
            backgroundColor = if (state.selectedLevel == "Easy") color.primary else color.onSecondary,
            onClickItemLevel = onLevelSelected
        )
        ItemLevel(
            color = color,
            text = "Medium",
            backgroundColor = if (state.selectedLevel == "Medium") color.primary else color.onSecondary,
            onClickItemLevel = onLevelSelected
        )
        ItemLevel(
            color = color,
            text = "Hard",
            backgroundColor = if (state.selectedLevel == "Hard") color.primary else color.onSecondary,
            onClickItemLevel = onLevelSelected
        )
    }
}