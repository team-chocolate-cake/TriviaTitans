package com.chocolate.triviatitans.ui.screens.level.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.chocolate.triviatitans.presentation.theme.CustomColorsPalette
import com.chocolate.triviatitans.presentation.theme.LightOnSecondary
import com.chocolate.triviatitans.presentation.screens.level.viewModel.LevelUiState
import com.chocolate.triviatitans.presentation.screens.level.viewModel.TypeLevel

@Composable
fun ItemLevel(
    color: CustomColorsPalette,
    state: LevelUiState,
    typeLevel: TypeLevel,
    painter: Painter,
    onClickItemLevel: (TypeLevel) -> Unit
) {

    val backgroundColor = remember(state.selectedLevel, color.primary) {
        if (state.selectedLevel == typeLevel) color.primary else Color.Transparent
    }
    val borderColor = remember(state.selectedLevel, color.primary) {
        if (state.selectedLevel == typeLevel) Color.Transparent else LightOnSecondary
    }

    val containerColor = remember(state.selectedLevel, color.primary){
        if(state.selectedLevel == typeLevel) Color.White else color.onBackground60
    }

    Column(
        modifier = Modifier
            .width(90.dp)
            .height(120.dp)
            .border(width = 1.dp, color = borderColor, shape = RoundedCornerShape(8.dp))
            .clip(shape = RoundedCornerShape(8.dp))
            .clickable { onClickItemLevel(typeLevel) }
            .background(color = backgroundColor)


    ) {
        Icon(
            painter = painter,
            contentDescription = "level ${typeLevel.name}",
            tint = containerColor,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 26.dp, bottom = 8.dp)
        )
        Text(
            text = typeLevel.name,
            color = containerColor,
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(start = 16.dp, end = 16.dp),
            maxLines = 1
        )
    }
}