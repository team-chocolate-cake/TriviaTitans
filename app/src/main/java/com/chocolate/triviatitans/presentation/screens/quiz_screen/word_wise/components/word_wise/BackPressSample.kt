package com.chocolate.triviatitans.presentation.screens.quiz_screen.word_wise.components.word_wise

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp
import com.chocolate.triviatitans.presentation.screens.quiz_screen.word_wise.view_model.BackPress
import com.chocolate.triviatitans.presentation.theme.LightError
import com.chocolate.triviatitans.presentation.theme.OnPrimary
import com.chocolate.triviatitans.presentation.theme.Primary
import kotlinx.coroutines.delay

@Composable
fun BackPressSample(OnBackToLevel: () -> Unit) {
    var showDialog by remember { mutableStateOf(false) }

    var backPressState by remember { mutableStateOf<BackPress>(BackPress.Idle) }

    if (showDialog) {
        ExitDialogBox(
            Primary,
            LightError,
            18.dp
        ) { OnBackToLevel() }
        showDialog = true
    }


    LaunchedEffect(key1 = backPressState) {
        if (backPressState == BackPress.InitialTouch) {
            delay(3000)
            backPressState = BackPress.Idle
            showDialog = false
        }
    }

    BackHandler(backPressState == BackPress.Idle) {
        backPressState = BackPress.InitialTouch
        if (!showDialog) {
            showDialog = true
        }
    }
}
