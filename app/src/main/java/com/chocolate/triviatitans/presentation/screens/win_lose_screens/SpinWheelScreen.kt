package com.chocolate.triviatitans.presentation.screens.win_lose_screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.chocolate.triviatitans.R
import com.chocolate.triviatitans.presentation.screens.win_lose_screens.components.Wheel
import com.chocolate.triviatitans.presentation.screens.win_lose_screens.view_model.SpinWheelViewModel
import com.chocolate.triviatitans.presentation.theme.LightOnBackground87

@Composable
fun SpinWheelScreen(
    navController: NavController,
    viewModel: SpinWheelViewModel = hiltViewModel()
) {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        val (spinText, wheel) = createRefs()
        Text(
            text = stringResource(R.string.spin_the_wheel_to_get_your_reward),
            modifier = Modifier
                .constrainAs(spinText) {
                    top.linkTo(parent.top, margin = 88.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            textAlign = TextAlign.Center,
            fontSize = 22.sp,
            color = LightOnBackground87
        )
        Wheel(
            context = LocalContext.current,
            navController = navController
        )
    }
}
