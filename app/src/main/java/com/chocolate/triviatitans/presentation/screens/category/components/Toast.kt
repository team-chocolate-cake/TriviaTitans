package com.chocolate.triviatitans.presentation.screens.category.components

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalContext
import kotlinx.coroutines.launch

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun CreateToast(message: String) {
    val coroutineScope = rememberCoroutineScope()
    val context = LocalContext.current
    coroutineScope.launch {
        android.widget.Toast.makeText(context, message, android.widget.Toast.LENGTH_SHORT)
            .show()
    }
}