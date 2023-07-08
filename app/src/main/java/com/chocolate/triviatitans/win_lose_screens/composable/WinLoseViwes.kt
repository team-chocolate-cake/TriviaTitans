package com.chocolate.triviatitans.win_lose_screens.composable

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.chocolate.triviatitans.presentation.theme.firaSansFamily
import com.chocolate.triviatitans.ui.theme.GameOver
import com.chocolate.triviatitans.ui.theme.LightBackground
import com.chocolate.triviatitans.ui.theme.LightOnBackground38
import com.chocolate.triviatitans.ui.theme.LightOnBackground60

@Composable
fun TextTitle(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text, fontFamily = firaSansFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 24.sp,
        color = GameOver,
        modifier = modifier,
    )
}

@Composable
fun TextDescription(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        fontFamily = firaSansFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp,
        color = LightOnBackground60,
        textAlign = TextAlign.Center,
        modifier = modifier
    )
}

@Composable
fun ButtonWinLose(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    buttonColor: Color = LightBackground,
    borderColor: Color = LightOnBackground38,
    textColor: Color = LightOnBackground60
) {
    Button(
        onClick = { onClick() },
        colors = ButtonDefaults.buttonColors(containerColor = buttonColor),
        modifier = modifier.fillMaxWidth(),
        border = BorderStroke(1.dp, borderColor)
    ) {
        Text(
            text = text,
            color = textColor,
            fontFamily = firaSansFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp
        )
    }
}