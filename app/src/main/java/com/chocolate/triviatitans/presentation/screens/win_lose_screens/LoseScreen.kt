package com.chocolate.triviatitans.presentation.screens.win_lose_screens


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.chocolate.triviatitans.R
import com.chocolate.triviatitans.presentation.screens.win_lose_screens.composable.ButtonWinLose
import com.chocolate.triviatitans.presentation.screens.win_lose_screens.composable.SpaceTop
import com.chocolate.triviatitans.presentation.screens.win_lose_screens.composable.TextDescription
import com.chocolate.triviatitans.presentation.screens.win_lose_screens.composable.TextTitle
import com.chocolate.triviatitans.presentation.screens.win_lose_screens.composable.WinLoseAnimation
import com.chocolate.triviatitans.ui.theme.LightBackground
import com.chocolate.triviatitans.ui.theme.LightOnBackground38
import com.chocolate.triviatitans.ui.theme.LightOnBackground60
import com.chocolate.triviatitans.ui.theme.Primary


@Preview(showSystemUi = true)
@Composable
fun LoseScreen() {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        val (lottie, gamOver, description, retry, returnToHome) = createRefs()
        WinLoseAnimation(
            R.raw.lose,
            modifier = Modifier
                .height(150.dp)
                .width(150.dp)
                .background(LightBackground)
                .constrainAs(lottie) {
                    top.linkTo(parent.top , margin = 164.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                })

        TextTitle(text = stringResource(R.string.game_over),
            modifier = Modifier.constrainAs(gamOver) {
                top.linkTo(lottie.bottom, margin = 32.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            })

        SpaceTop(space = 24)
        TextDescription(
            stringResource(R.string.unfortionatly_u_lose_this_please_retry_it),
            modifier = Modifier.constrainAs(description) {
                top.linkTo(gamOver.bottom, margin = 24.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            })

        ButtonWinLose(
            text = stringResource(R.string.retry),
            onClick = {},
            buttonColor = Primary,
            borderColor = Color.Transparent,
            textColor = LightBackground,
            modifier = Modifier.constrainAs(retry) {
                bottom.linkTo(returnToHome.top)
                start.linkTo(parent.start, margin = 16.dp)
                end.linkTo(parent.end, margin = 16.dp)
            }
        )
        ButtonWinLose(
            text = stringResource(R.string.return_to_home),
            onClick = {},
            buttonColor = LightBackground,
            borderColor = LightOnBackground38,
            textColor = LightOnBackground60,
            modifier = Modifier.constrainAs(returnToHome) {
                bottom.linkTo(parent.bottom, margin = 164.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        )
    }
}