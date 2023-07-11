package com.chocolate.triviatitans.presentation.screens.win

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.chocolate.triviatitans.presentation.Screens

fun NavGraphBuilder.winRoute(navController: NavHostController) {
    composable(
        "${Screens.WinScreen.route}/{prize}/{prize_type}",
        arguments = listOf(
            navArgument("prize") { NavType.IntType },
            navArgument("prize_type") { NavType.StringType }
        )
    ) { WinScreen(navController = navController) }
}

fun NavController.navigateToWinScreen(prize: String, prizeType: String) {
    navigate("${Screens.WinScreen.route}/${prize.take(1)}/${prizeType}")
}