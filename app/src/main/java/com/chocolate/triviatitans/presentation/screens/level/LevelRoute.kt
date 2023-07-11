package com.chocolate.triviatitans.presentation.screens.level

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.chocolate.triviatitans.presentation.Screens

fun NavGraphBuilder.levelRoute(navController: NavController) {
    composable(
        "${Screens.LevelScreen.route}/{categories}/{game_type}",
        arguments = listOf(
            navArgument("categories") { NavType.StringType},
            navArgument("game_type"){NavType.IntType}
        )
    ) {
        LevelScreen(navController = navController)
    }
}
fun NavController.navigateToLevel(categories: String="",gameType:Int=0) {
    navigate("${Screens.LevelScreen.route}/$categories/$gameType")
}