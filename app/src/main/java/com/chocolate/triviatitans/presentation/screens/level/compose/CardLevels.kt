package com.chocolate.triviatitans.ui.screens.level.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.chocolate.triviatitans.R
import com.chocolate.triviatitans.presentation.theme.CustomColorsPalette
import com.chocolate.triviatitans.presentation.screens.level.viewModel.LevelUiState
import com.chocolate.triviatitans.presentation.screens.level.viewModel.TypeLevel

@Composable
fun CardLevels(
    color: CustomColorsPalette,
    onLevelSelected: (TypeLevel) -> Unit,
    state: LevelUiState
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(
            8.dp,
            alignment = Alignment.CenterHorizontally
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 40.dp)
    ) {
        ItemLevel(
            color = color,
            state = state,
            typeLevel = TypeLevel.Easy,
            painter = painterResource(id = R.drawable.ic_easy_level),
            onClickItemLevel = {onLevelSelected(it)}
        )
        ItemLevel(
            color = color,
            state = state,
            typeLevel = TypeLevel.Medium,
            painter = painterResource(id = R.drawable.ic_medium_level),
            onClickItemLevel = {onLevelSelected(it)}
        )
        ItemLevel(
            color = color,
            state = state,
            typeLevel = TypeLevel.Hard,
            painter = painterResource(id = R.drawable.ic_hard_level),
            onClickItemLevel = {onLevelSelected(it)}
        )
    }
}