package com.chocolate.triviatitans.presentation.screens.quiz_screen.text_game

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.chocolate.triviatitans.presentation.Screens
import com.chocolate.triviatitans.presentation.screens.quiz_screen.word_wise.WordWiseScreen

fun NavGraphBuilder.textGameRoute(navController: NavHostController) {
    composable(
        "${Screens.TextGameScreen.route}/{categories}/{game_type}/{level_type}",
        arguments = listOf(
            navArgument("categories") { NavType.StringType },
            navArgument("level_type") { NavType.StringType }
        )
    ) {
        TextGameScreen(navController = navController)
    }
}

fun NavController.navigateToTextGame(categories: String="",levelArgs: String="") {
    navigate("${Screens.TextGameScreen.route}/$categories/$levelArgs")
}