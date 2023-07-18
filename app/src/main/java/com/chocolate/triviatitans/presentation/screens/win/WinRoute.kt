package com.chocolate.triviatitans.presentation.screens.win

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.chocolate.triviatitans.presentation.Screens
import com.chocolate.triviatitans.presentation.screens.win.PrizeArgs.Companion.PRIZE
import com.chocolate.triviatitans.presentation.screens.win.PrizeArgs.Companion.PRIZE_TYPE

fun NavGraphBuilder.winRoute(navController: NavHostController) {
    composable(
        "${Screens.WinScreen.route}/{$PRIZE}/{$PRIZE_TYPE}",
        arguments = listOf(
            navArgument(PRIZE) { NavType.IntType },
            navArgument(PRIZE_TYPE) { NavType.StringType }
        )
    ) { WinScreen(navController = navController) }
}

fun NavController.navigateToWinScreen(prize: String, prizeType: String) {
    navigate("${Screens.WinScreen.route}/${prize.take(1)}/${prizeType}")
}

class PrizeArgs(savedStateHandle: SavedStateHandle){
    val prize = checkNotNull(savedStateHandle[PRIZE])
    val prizeType = checkNotNull(savedStateHandle[PRIZE_TYPE])
    companion object{
        const val PRIZE = "prize"
        const val PRIZE_TYPE = "prize_type"
    }
}