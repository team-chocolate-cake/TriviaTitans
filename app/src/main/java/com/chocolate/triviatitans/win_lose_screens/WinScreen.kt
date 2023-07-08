package com.chocolate.triviatitans.win_lose_screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.chocolate.triviatitans.R
import com.chocolate.triviatitans.presentation.theme.GameOver
import com.chocolate.triviatitans.presentation.theme.LightBackground
import com.chocolate.triviatitans.presentation.theme.LightOnBackground38
import com.chocolate.triviatitans.presentation.theme.LightOnBackground60
import com.chocolate.triviatitans.presentation.theme.Primary
import com.chocolate.triviatitans.presentation.theme.firaSansFamily
import com.chocolate.triviatitans.win_lose_screens.composable.CongratulationsAnimation
import com.chocolate.triviatitans.win_lose_screens.composable.SpaceTop


@Preview(showSystemUi = true)
@Composable
fun WinScreen() {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        val (lottie, present, congrats, points, nextLevel, returnToHome) = createRefs()
        CongratulationsAnimation(
            R.raw.congratulations,
            modifier = Modifier
                .height(500.dp)
                .background(LightBackground)
                .constrainAs(lottie) { top.linkTo(parent.top) })
        Image(
            painter = painterResource(id = R.drawable.present),
            contentDescription = "present image",
            modifier = Modifier.constrainAs(present) {
                top.linkTo(parent.top, margin = 180.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        )
        Text(
            text = "Congrats", fontFamily = firaSansFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 24.sp,
            color = GameOver,
            modifier = Modifier.constrainAs(congrats) {
                top.linkTo(present.bottom, margin = 32.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            },
        )
        SpaceTop(space = 24)
        Text(
            text = "You earned 200 points\n and unlock level 2",
            fontFamily = firaSansFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 18.sp,
            color = LightOnBackground60,
            textAlign = TextAlign.Center,
            modifier = Modifier.constrainAs(points) {
                top.linkTo(congrats.bottom, margin = 24.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        )

        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(containerColor = Primary),
            modifier = Modifier
                .constrainAs(nextLevel) {
                    bottom.linkTo(returnToHome.top)
                    start.linkTo(parent.start, margin = 16.dp)
                    end.linkTo(parent.end, margin = 16.dp)
                }
                .fillMaxWidth()
        ) {
            Text(
                text = "Go to next level",
                fontFamily = firaSansFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp
            )
        }
        Button(
            modifier = Modifier
                .constrainAs(returnToHome) {
                    bottom.linkTo(parent.bottom, margin = 164.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .fillMaxWidth(),
            onClick = {},
            border = BorderStroke(1.dp, LightOnBackground38),
            colors = ButtonDefaults.buttonColors(containerColor = LightBackground),

            ) {
            Text(
                modifier = Modifier,
                text = "Return to home", color = LightOnBackground60,
                fontFamily = firaSansFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp
            )
        }
    }
}