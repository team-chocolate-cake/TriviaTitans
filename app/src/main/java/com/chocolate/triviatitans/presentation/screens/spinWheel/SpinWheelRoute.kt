package com.chocolate.triviatitans.presentation.screens.spinWheel

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.chocolate.triviatitans.presentation.Screens

fun NavGraphBuilder.spinWheelRoute(navController: NavHostController) {
    composable(Screens.SpinWheelScreen.route) {
        SpinWheelScreen(navController = navController)
    }
}

fun NavController.navigateToSpinWheelScreen() {
    navigate(Screens.SpinWheelScreen.route)
}