package com.chocolate.triviatitans.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)
val DarkBackground = Color(0xFF002B44)
val DarkOnBackground87 = Color(0xDEF6F6F6)
val DarkOnBackground60 = Color(0x99F6F6F6)
val DarkOnBackground38 = Color(0x61F6F6F6)
val DarkSecondary = Color(0xFF87CEF6)
val DarkCard = Color(0xFF245977)
val DarkBorder = Color(0x149C99A1)
val DarkError = Color(0xC7FF0000)
val DarkOnSecondary = Color(0xFF1F1F1F)



val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)
val LightBackground = Color(0x99F3FBFF)
val LightOnBackground87 = Color(0xDE121212)
val LightOnBackground60 = Color(0x99121212)
val LightOnBackground38 = Color(0x61121212)
val LightSecondary = Color(0xFFEDECEF)
val LightCard = Color(0xFFFFFFFF)
val LightBorder = Color(0x14845EC2)
val LightError = Color(0x99FF0000)
val LightOnSecondary = Color(0xFFA0D3EF)



val Primary = Color(0xFF27A5EC)
val OnPrimary = Color(0xFFFFFFFF)
val Correct = Color(0xCC32CD32)
val GameOver = Color(0xFFF4AF00)


@Immutable
data class CustomColorsPalette(
    val primary: Color = Color.Unspecified,
    val onPrimary: Color = Color.Unspecified,
    val secondary: Color = Color.Unspecified,
    val onSecondary: Color = Color.Unspecified,
    val onBackground87: Color = Color.Unspecified,
    val onBackground60: Color = Color.Unspecified,
    val onBackground38: Color = Color.Unspecified,
    val card: Color = Color.Unspecified,
    val border: Color = Color.Unspecified,
    val background: Color = Color.Unspecified,
    val correct: Color = Color.Unspecified,
    val gameOver: Color = Color.Unspecified,
    val error: Color = Color.Unspecified
)
