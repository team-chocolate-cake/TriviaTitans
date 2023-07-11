package com.chocolate.triviatitans.presentation.screens.lose

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.chocolate.triviatitans.presentation.Screens

fun NavGraphBuilder.loseRoute(navController: NavHostController) {
    composable(Screens.LoseScreen.route) {
        LoseScreen(navController = navController)
    }
}

fun NavController.navigateToLose() {
    navigate(Screens.LoseScreen.route)
}