package com.chocolate.triviatitans.presentation.screens.win_lose_screens

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.chocolate.triviatitans.presentation.Screens
import com.chocolate.triviatitans.presentation.screens.quiz_screen.QuizScreen

fun NavGraphBuilder.loseRoute(navController: NavHostController) {
    composable(Screens.LoseScreen.route) {
        LoseScreen(navController = navController)
    }
}

fun NavController.navigateToLose() {
    navigate(Screens.LoseScreen.route)
}