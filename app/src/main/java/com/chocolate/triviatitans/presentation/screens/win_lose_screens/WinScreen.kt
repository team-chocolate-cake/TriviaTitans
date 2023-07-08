package com.chocolate.triviatitans.win_lose_screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.chocolate.triviatitans.R
import com.chocolate.triviatitans.ui.theme.LightBackground
import com.chocolate.triviatitans.ui.theme.LightOnBackground38
import com.chocolate.triviatitans.ui.theme.LightOnBackground60
import com.chocolate.triviatitans.ui.theme.Primary
import com.chocolate.triviatitans.win_lose_screens.composable.ButtonWinLose
import com.chocolate.triviatitans.win_lose_screens.composable.SpaceTop
import com.chocolate.triviatitans.win_lose_screens.composable.TextDescription
import com.chocolate.triviatitans.win_lose_screens.composable.TextTitle
import com.chocolate.triviatitans.win_lose_screens.composable.WinLoseAnimation


@Preview(showSystemUi = true)
@Composable
fun WinScreen() {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        val (lottie,
            present,
            congrats,
            points,
            nextLevel,
            returnToHome) = createRefs()
        WinLoseAnimation(
            R.raw.congratulations,
            modifier = Modifier
                .height(500.dp)
                .background(LightBackground)
                .constrainAs(lottie) { top.linkTo(parent.top) })
        Image(
            painter = painterResource(id = R.drawable.present),
            contentDescription = stringResource(R.string.present_image),
            modifier = Modifier.constrainAs(present) {
                top.linkTo(parent.top, margin = 180.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        )
        TextTitle(text = stringResource(R.string.congrats),
            modifier = Modifier.constrainAs(congrats) {
                top.linkTo(present.bottom, margin = 32.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            })
        SpaceTop(space = 24)
        TextDescription(
            stringResource(R.string.you_earned_200_points),
            modifier = Modifier.constrainAs(points) {
                top.linkTo(congrats.bottom, margin = 24.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            })

        ButtonWinLose(
            text = stringResource(R.string.go_to_next_level),
            onClick = {},
            buttonColor = Primary,
            borderColor = Color.Transparent,
            textColor = LightBackground,
            modifier = Modifier.constrainAs(nextLevel) {
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