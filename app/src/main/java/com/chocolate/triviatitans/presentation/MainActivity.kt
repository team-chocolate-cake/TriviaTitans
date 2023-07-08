package com.chocolate.triviatitans.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.chocolate.triviatitans.presentation.screens.quiz_screen.QuizScreen
import com.chocolate.triviatitans.presentation.screens.word_wise_screen.WordWiseScreen
import com.chocolate.triviatitans.presentation.theme.TriviaTitansTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TriviaTitansTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    WordWiseScreen()
                }
            }
        }
    }
}