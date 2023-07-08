package com.chocolate.triviatitans.win_lose_screens

import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.chocolate.triviatitans.R
import com.chocolate.triviatitans.presentation.theme.LightOnBackground87
import com.chocolate.triviatitans.win_lose_screens.composable.Wheel

@Preview(showSystemUi = true)
@Composable
fun SpinWheel() {
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
            modifier = Modifier.constrainAs(wheel) {
                top.linkTo(spinText.bottom, margin = 90.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
                .fillMaxWidth()
                .aspectRatio(1f),
            context = LocalContext.current
        )
    }
}

