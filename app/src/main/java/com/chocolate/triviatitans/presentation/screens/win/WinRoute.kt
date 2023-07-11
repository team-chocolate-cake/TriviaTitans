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
        "${Screens.WinScreen.route}/{prize}",
        arguments = listOf(
            navArgument("prize") { NavType.StringType }
        )
    ) { backStackEntry ->
        val prize = backStackEntry.arguments?.getString("prize") ?: ""
        WinScreen(navController = navController, prize = prize)
    }
}

fun NavController.navigateToWinScreen(prize: String) {
    navigate("${Screens.WinScreen.route}/$prize")
}