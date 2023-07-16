package com.chocolate.triviatitans.presentation.screens.category

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.chocolate.triviatitans.presentation.Screens

fun NavGraphBuilder.categoryRoute(navController: NavController) {
    composable(
        "${Screens.CategoryScreen.route}/{game_type}",
        arguments = listOf(
            navArgument("game_type") { NavType.IntType}
        )) {
        CategoryScreen(navController = navController)
    }
}

fun NavController.navigateToCategory(gameType: Int) {
    navigate("${Screens.CategoryScreen.route}/$gameType")
}

