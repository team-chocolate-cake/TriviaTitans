package com.chocolate.triviatitans.win_lose_screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.chocolate.triviatitans.R
import com.chocolate.triviatitans.ui.theme.OnSecondary
import com.chocolate.triviatitans.ui.theme.Primary
import com.chocolate.triviatitans.ui.theme.firaSansFamily
import com.chocolate.triviatitans.win_lose_screens.composable.CongratulationsAnimation
import com.chocolate.triviatitans.win_lose_screens.composable.SpaceTop
import com.chocolate.triviatitans.win_lose_screens.composable.SpaceVertical


@Preview(showSystemUi = true)
@Composable
fun WinScreen() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box {
            SpaceVertical(space = 120)
            CongratulationsAnimation(R.raw.congratulations)
            Image(
                painter = painterResource(id = R.drawable.present),
                contentDescription = "present image",
                modifier = Modifier.align(Alignment.Center)
            )
        }
        SpaceVertical(space = 24)
        Text(
            text = "Congrats", fontFamily = firaSansFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 22.sp
        )
        SpaceTop(space = 32)
        Text(
            text = "You earned 200 points and unlock level 2",
            fontFamily = firaSansFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
            textAlign = TextAlign.Center
        )
        SpaceTop(space = 60)
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