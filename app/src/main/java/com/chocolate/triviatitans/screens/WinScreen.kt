package com.chocolate.triviatitans.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieAnimationSpec
import com.airbnb.lottie.compose.rememberLottieAnimationState
import com.chocolate.triviatitans.R
import com.chocolate.triviatitans.ui.theme.OnSecondary
import com.chocolate.triviatitans.ui.theme.Primary
import com.chocolate.triviatitans.ui.theme.firaSansFamily


@Preview(showSystemUi = true)
@Composable
fun WinScreen() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.padding(top = 160.dp))
        CongratulationsAnimation()
        Image(
            painter = painterResource(id = R.drawable.present),
            contentDescription = "present image"
        )
        Spacer(modifier = Modifier.padding(top = 100.dp))
        Text(
            text = "Congrats", fontFamily = firaSansFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 22.sp
        )
        Spacer(modifier = Modifier.padding(top = 32.dp))
        Text(
            text = "You earned 200 points and unlock level 2",
            fontFamily = firaSansFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.padding(top = 80.dp))
        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(containerColor = Primary),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            Text(
                text = "Go to next level",
                fontFamily = firaSansFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp
            )
        }
        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(containerColor = OnSecondary),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            Text(
                text = "Return to home", color = Primary,
                fontFamily = firaSansFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp
            )
        }
    }
}

@Composable
fun CongratulationsAnimation() {
    val animationSpec = remember { LottieAnimationSpec.RawRes(R.raw.congratulations) }
    val animationState =
        rememberLottieAnimationState(autoPlay = true, repeatCount = Integer.MAX_VALUE)
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .background(Color.White),
        verticalArrangement = Arrangement.Center
    ) {

        LottieAnimation(animationSpec, animationState = animationState)
    }
}