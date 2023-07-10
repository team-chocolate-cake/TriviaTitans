package com.chocolate.triviatitans.presentation.screens.quiz_screen.components.multi_choice

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun HintAlertDialog(onDissmiss: () -> Unit, correctAnswer: String) {
    AlertDialog(
        onDismissRequest = onDissmiss,
        title = { Text("Answer") },
        text = { Text(correctAnswer) },
        confirmButton = {
            TextButton(onClick = onDissmiss) {
                Text("Ok".uppercase())
            }
        },

        )
}

@Preview
@Composable
fun HintAlertDialogPreview() {

}