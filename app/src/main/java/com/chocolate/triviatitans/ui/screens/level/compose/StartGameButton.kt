package com.chocolate.triviatitans.ui.screens.level.compose

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.chocolate.triviatitans.ui.theme.CustomColorsPalette

@Composable
fun StartGameButton(
    color: CustomColorsPalette,
    onClickStartGame: () -> Unit,
    ) {
    Button(
        onClick = onClickStartGame,
        colors = ButtonDefaults.buttonColors(color.primary, disabledContainerColor = color.onSecondary),
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(horizontal = 40.dp)
            .padding(vertical = 16.dp),

    ) {
        Text(
            text = "START GAME",
            color = Color.White.copy(alpha = 0.87f),
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        )
    }
}