package com.chocolate.triviatitans.presentation.screens.win

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.chocolate.triviatitans.R
import com.chocolate.triviatitans.composables.ButtonWinLose
import com.chocolate.triviatitans.composables.ImageView
import com.chocolate.triviatitans.composables.SpacerVertical24
import com.chocolate.triviatitans.composables.TextDescription
import com.chocolate.triviatitans.composables.TextTitle
import com.chocolate.triviatitans.composables.WinLoseAnimation
import com.chocolate.triviatitans.presentation.Screens
import com.chocolate.triviatitans.presentation.screens.home.navigateToHome
import com.chocolate.triviatitans.presentation.screens.level.navigateToLevel
import com.chocolate.triviatitans.presentation.theme.LightBackground
import com.chocolate.triviatitans.presentation.theme.LightOnBackground38
import com.chocolate.triviatitans.presentation.theme.LightOnBackground60
import com.chocolate.triviatitans.presentation.theme.Primary
import com.chocolate.triviatitans.presentation.theme.TriviaTitansTheme
import com.chocolate.triviatitans.presentation.theme.Win

@Composable
fun WinScreen(navController: NavController ,winViewModel: WinViewModel = hiltViewModel()) {
    val winUiState = winViewModel.state.collectAsState()
    TriviaTitansTheme() {
        WinContent(
            onClickToHome = { navController.navigateToHome() },
            onClickToNextGame = {
                navController.popBackStack(Screens.LevelScreen.route, true)
            },
            prize = winViewModel.args.toString(),
            prizeType = winViewModel.prizeType.toString()
        )
    }
}

@Composable
fun WinContent(
    onClickToHome: () -> Unit,
    onClickToNextGame: () -> Unit,
    prize: String,
    prizeType: String
) {

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(Win)
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
        ImageView(
            ImageResource = R.drawable.present,
            contentDescription = stringResource(R.string.present_image),
            modifier = Modifier.constrainAs(present) {
                top.linkTo(parent.top, margin = 220.dp)
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
        SpacerVertical24()
        TextDescription(
            stringResource(R.string.you_earned_200_points) + ' ' + prize + ' ' + prizeType,
            modifier = Modifier.constrainAs(points) {
                top.linkTo(congrats.bottom, margin = 24.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            })

        ButtonWinLose(
            text = stringResource(R.string.go_to_next_game),
            onClick = { onClickToNextGame() },
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
            onClick = { onClickToHome() },
            buttonColor = LightBackground,
            borderColor = LightOnBackground38,
            textColor = LightOnBackground60,
            modifier = Modifier.constrainAs(returnToHome) {
                bottom.linkTo(parent.bottom, margin = 164.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        )

        BackHandler(enabled = true) {
            onClickToNextGame()
        }
    }
}