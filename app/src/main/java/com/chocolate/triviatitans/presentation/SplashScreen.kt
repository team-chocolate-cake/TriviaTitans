package com.chocolate.triviatitans.presentation

import android.window.SplashScreen
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.chocolate.triviatitans.R
import com.chocolate.triviatitans.composables.ImageView
import com.chocolate.triviatitans.presentation.screens.home.navigateToHome
import com.chocolate.triviatitans.presentation.theme.TriviaTitansTheme
import com.chocolate.triviatitans.presentation.theme.customColor
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {
    LaunchedEffect(key1 = true) {
        delay(2000)
        navController.popBackStack()
        navController.navigateToHome()
    }
    TriviaTitansTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.customColor().background
        ) {
            ConstraintLayout(modifier = Modifier.fillMaxSize()) {
                val (Image , text) = createRefs()
                val guideline = createGuidelineFromTop(0.3f)
                Box(contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .constrainAs(Image) {
                            top.linkTo(guideline)
                        }) {
                    ImageView(
                        ImageResource = R.drawable.app_icon,
                        modifier = Modifier
                            .size(150.dp)
                            .padding(bottom = 16.dp)
                    )
                }
                Box(contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .constrainAs(text) {
                            top.linkTo(Image.bottom)
                        },
                    ) {
                    Text(
                        fontSize = 32.sp,
                        text = "Trivia\n\nTitans",
                        color = MaterialTheme.customColor().onBackground87,
                        fontWeight = FontWeight.SemiBold,
                        fontStyle = FontStyle.Italic
                    )
                }
            }
        }
    }
}