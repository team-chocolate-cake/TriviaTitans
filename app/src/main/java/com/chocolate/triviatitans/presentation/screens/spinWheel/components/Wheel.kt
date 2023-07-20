package com.chocolate.triviatitans.presentation.screens.spinWheel.components

import android.content.Context
import android.widget.Toast
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.chocolate.triviatitans.presentation.screens.win.navigateToWinScreen
import com.chocolate.triviatitans.presentation.theme.LightOnBackground87
import com.commandiron.spin_wheel_compose.SpinWheel
import com.commandiron.spin_wheel_compose.SpinWheelDefaults
import com.commandiron.spin_wheel_compose.state.rememberSpinWheelState
import kotlinx.coroutines.launch

private fun prizeType(selectedPie: String, randomNumberOfGifts: List<Int>): String {
    return when (selectedPie) {
        "${randomNumberOfGifts[0]} Bonus" -> "bonus"
        "${randomNumberOfGifts[1]} Hearts" -> "hearts"
        "${randomNumberOfGifts[2]} Delete Two answers" -> "deleteTwoAnswers"
        "${randomNumberOfGifts[3]} Change The Question" -> "changeQuestion"
        else -> ""
    }
}

@Composable
fun Wheel(context: Context, navController: NavController, modifier: Modifier = Modifier) {
    val selectedPie = remember { mutableStateOf("") }
    val randomNumberOfGifts by remember {
        mutableStateOf(
            List(4) { (1..10).random() }
        )
    }
    val iconList = remember(randomNumberOfGifts) {
        listOf(
            "${randomNumberOfGifts[0]} Bonus",
            "${randomNumberOfGifts[1]} Hearts",
            "${randomNumberOfGifts[2]} Delete Two answers",
            "${randomNumberOfGifts[3]} Change The Question",
            "1 Hard Luck"
        )
    }
    val spinWheelState = rememberSpinWheelState(
        pieCount = 5,
        durationMillis = 20000,
        delayMillis = 200,
        rotationPerSecond = 2f,
        easing = LinearOutSlowInEasing,
        startDegree = 90f,
        autoSpinDelay = null
    )
    val coroutineScope = rememberCoroutineScope()
    val spinningState = remember { mutableStateOf(false) }

    Box(
        modifier = modifier
            .fillMaxSize()
            .clickable {
                if (!spinningState.value) {
                    spinningState.value = true
                    coroutineScope.launch {
                        spinWheelState.spin { pieIndex ->
                            selectedPie.value = iconList[pieIndex]
                            Toast
                                .makeText(
                                    context,
                                    "Selected Pie: ${selectedPie.value}",
                                    Toast.LENGTH_SHORT
                                )
                                .show()
                            spinningState.value = false
                            val prizeType = prizeType(selectedPie.value, randomNumberOfGifts)
                            navController.navigateToWinScreen(selectedPie.value.take(1), prizeType)
                        }
                    }
                }
            },
        contentAlignment = Alignment.Center
    ) {
        SpinWheel(
            state = spinWheelState,
            dimensions = SpinWheelDefaults.spinWheelDimensions(
                spinWheelSize = 400.dp,
                frameWidth = 20.dp,
                selectorWidth = 10.dp
            ),
            colors = SpinWheelDefaults.spinWheelColors(
                frameColor = Color.Transparent,
                dividerColor = Color.Transparent,
                selectorColor = Color(0xFF091520),
                pieColors = listOf(
                    Color(0xFF2F97F3),
                    Color(0xFFA9CFFB),
                    Color(0xFF2F97F3),
                    Color(0xFFEDE171),
                    Color(0xFFA9CFFB)
                )
            )
        ) { pieIndex ->
            Box(
                modifier = modifier
                    .fillMaxSize()
                    .padding(8.dp)
            ) {
                Text(
                    text = iconList[pieIndex],
                    color = LightOnBackground87,
                    textAlign = TextAlign.Center,
                    fontSize = 16.sp,
                    modifier = Modifier.align(Alignment.Center)
                )
                if (!spinningState.value) {
                    selectedPie.value = iconList[pieIndex]
                }
            }
        }
    }
}