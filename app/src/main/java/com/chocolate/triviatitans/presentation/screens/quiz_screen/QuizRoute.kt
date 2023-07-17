package com.chocolate.triviatitans.presentation.screens.quiz_screen

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.chocolate.triviatitans.presentation.Screens

fun NavGraphBuilder.quizRoute(navController: NavHostController) {
    composable(
        "${Screens.QuizScreen.route}/{categories}/{game_type}/{level_type}",
        arguments = listOf(
            navArgument("categories") { NavType.StringType },
            navArgument("game_type") { NavType.StringType },
            navArgument("level_type") { NavType.StringType }
        )
    ) {
        QuizScreen(navController = navController)
    }
}

fun NavController.navigateToQuiz(categories: String="", gameType: String="", levelArgs: String="") {
    navigate("${Screens.QuizScreen.route}/$categories/$gameType/$levelArgs")
}