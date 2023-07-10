package com.chocolate.triviatitans.presentation.screens.category.components

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalContext

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun CreateToast(message: String) {
  //  val coroutineScope = rememberCoroutineScope()
    val context = LocalContext.current
    Toast.makeText(context, message, Toast.LENGTH_SHORT)
        .show()
}