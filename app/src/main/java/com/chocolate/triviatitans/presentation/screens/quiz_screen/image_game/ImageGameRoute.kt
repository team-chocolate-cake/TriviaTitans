package com.chocolate.triviatitans.presentation.screens.quiz_screen.image_game

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.chocolate.triviatitans.presentation.Screens
import com.chocolate.triviatitans.presentation.screens.quiz_screen.word_wise.WordWiseScreen

fun NavGraphBuilder.imageGameRoute(navController: NavHostController) {
    composable(
        "${Screens.ImageGameScreen.route}/{categories}/{level_type}",
        arguments = listOf(
            navArgument("categories") { NavType.StringType },
            navArgument("level_type") { NavType.StringType }
        )
    ) {
       ImageGameScreen(navController = navController)
    }
}

fun NavController.navigateToImageGame(categories: String="",levelArgs: String="") {
    navigate("${Screens.ImageGameScreen.route}/$categories/${levelArgs.lowercase()}")
}