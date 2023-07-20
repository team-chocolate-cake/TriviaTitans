package com.chocolate.triviatitans.presentation.screens.quiz_screen.components.multi_choice

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter

@Composable
fun HintAlertDialog(onDissmiss: () -> Unit, correctAnswer: String, isImageGame: Boolean) {
    AlertDialog(
        onDismissRequest = onDissmiss,
        title = { Text("Answer") },
        text = {
            if (isImageGame)
                Image(
                    modifier = Modifier
                        .fillMaxSize(),
                    painter = rememberAsyncImagePainter(model = correctAnswer),
                    contentDescription = "",
                ) else Text(correctAnswer)
        },
        confirmButton = {
            TextButton(onClick = onDissmiss) {
                Text("Ok".uppercase())
            }
        },
        modifier = Modifier.size(height = if (isImageGame) 400.dp else 200.dp, width = 400.dp).fillMaxWidth()
    )
}

@Preview
@Composable
fun HintAlertDialogPreview() {

}