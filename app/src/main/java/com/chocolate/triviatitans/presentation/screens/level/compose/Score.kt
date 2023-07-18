package com.chocolate.triviatitans.ui.screens.level.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.chocolate.triviatitans.presentation.theme.CustomColorsPalette
import com.chocolate.triviatitans.presentation.theme.LightOnSecondary
import com.chocolate.triviatitans.presentation.screens.level.viewModel.LevelUiState
import com.chocolate.triviatitans.presentation.screens.level.viewModel.ScoreByLevel
import com.chocolate.triviatitans.presentation.screens.level.viewModel.TypeLevel

@Composable
fun Score(
    scores: ScoreByLevel,
    selectedLevel:TypeLevel,
    colors: CustomColorsPalette,
) {
    val score = when(selectedLevel){
        TypeLevel.Easy -> scores.easy
        TypeLevel.Medium -> scores.medium
        TypeLevel.Hard -> scores.hard
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Score: $score" ,
            color = colors.onBackground87,
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier
                .wrapContentWidth()
                .border(width = 1.dp, color = LightOnSecondary, shape = RoundedCornerShape(32.dp))
                .background(colors.onSecondary, shape = RoundedCornerShape(32.dp))
                .padding(16.dp),
            textAlign = TextAlign.Center,
        )
    }
}