package com.chocolate.triviatitans.presentation.theme

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorScheme = darkColorScheme(
    primary = Primary,
    onPrimary = OnPrimary,
    secondary = DarkSecondary,
    onSecondary = DarkOnSecondary,
    tertiary = Pink80,
    background = DarkBackground,
)

private val LightColorScheme = lightColorScheme(
    primary = Primary,
    onPrimary = OnPrimary,
    secondary = LightSecondary,
    onSecondary = LightOnSecondary,
    tertiary = Pink40,
    background = LightBackground,
)

val OnLightCustomColorsPalette = CustomColorsPalette(
    primary = Primary,
    onPrimary = OnPrimary,
    secondary = LightSecondary,
    onSecondary = LightOnSecondary,
    onBackground87 = LightOnBackground87,
    onBackground60 = LightOnBackground60,
    onBackground38 = LightOnBackground38,
    card = LightCard,
    border = LightBorder,
    background = LightBackground,
    correct = Correct,
    gameOver = GameOver,
    error = LightError
)

val OnDarkCustomColorsPalette = CustomColorsPalette(
    primary = Primary,
    onPrimary = OnPrimary,
    secondary = DarkSecondary,
    onSecondary = DarkOnSecondary,
    onBackground87 = DarkOnBackground87,
    onBackground60 = DarkOnBackground60,
    onBackground38 = DarkOnBackground38,
    card = DarkCard,
    border = DarkBorder,
    background = DarkBackground,
    correct = Correct,
    gameOver = GameOver,
    error = DarkError
)

@SuppressLint("CompositionLocalNaming")
val TriviaCustomColors = staticCompositionLocalOf { CustomColorsPalette() }

@Composable
fun TriviaTitansTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }

    val customColorsPalette =
        if (darkTheme) OnDarkCustomColorsPalette
        else OnLightCustomColorsPalette

    CompositionLocalProvider(
        TriviaCustomColors provides customColorsPalette
    ) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = Typography,
            content = content
        )
    }

}
@Composable
fun MaterialTheme.customColor() = TriviaCustomColors.current