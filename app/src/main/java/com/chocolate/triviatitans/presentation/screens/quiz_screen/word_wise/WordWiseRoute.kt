package com.chocolate.triviatitans.presentation.screens.quiz_screen.word_wise

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.chocolate.triviatitans.presentation.Screens

fun NavGraphBuilder.wordWiseRoute(navController: NavHostController) {
    composable(
        "${Screens.WordWiseScreen.route}/{categories}/{game_type}/{level_type}",
        arguments = listOf(
            navArgument("categories") { NavType.StringType },
            navArgument("game_type") { NavType.IntType },
            navArgument("level_type") { NavType.StringType }
        )
    ) {
        WordWiseScreen(navController = navController)
    }
}

fun NavController.navigateToWordWise(categories: String="", gameType: Int=0, levelArgs: String="") {
    navigate("${Screens.WordWiseScreen.route}/$categories/$gameType/$levelArgs")
}