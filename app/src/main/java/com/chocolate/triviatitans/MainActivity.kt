package com.chocolate.triviatitans

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.chocolate.triviatitans.ui.theme.TriviaTitansTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TriviaTitansTheme() {

            }
        }
    }
}