package com.chocolate.triviatitans.presentation.screens.win

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.chocolate.triviatitans.presentation.Screens

fun NavGraphBuilder.winRoute(navController: NavHostController) {
    composable(Screens.WinScreen.route) {
        WinScreen(navController = navController)
    }
}

fun NavController.navigateToWinScreen() {
    navigate(Screens.WinScreen.route)
}