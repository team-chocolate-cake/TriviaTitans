package com.chocolate.triviatitans.presentation.screens.category

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.chocolate.triviatitans.presentation.Screens
import com.chocolate.triviatitans.presentation.screens.quiz_screen.GameType

fun NavGraphBuilder.categoryRoute(navController: NavController) {
    composable(
        "${Screens.CategoryScreen.route}/{gameTypeName}",
        arguments = listOf(
            navArgument("gameTypeName") { NavType.StringType }
        )) {
        CategoryScreen(navController = navController)
    }
}

fun NavController.navigateToCategory(gameType: GameType) {
    navigate("${Screens.CategoryScreen.route}/${gameType.name}")
}
