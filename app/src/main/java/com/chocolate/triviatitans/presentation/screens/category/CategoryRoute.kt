package com.chocolate.triviatitans.presentation.screens.category

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.chocolate.triviatitans.presentation.Screens

fun NavGraphBuilder.categoryRoute(navController: NavController) {
    composable(
        "${Screens.CategoryScreen.route}/{currentIndex}",
        arguments = listOf(
            navArgument("currentIndex") { NavType.IntType}
        )) {
        CategoryScreen(navController = navController)
    }
}

fun NavController.navigateToCategory(currentIndex: Int) {
    navigate("${Screens.CategoryScreen.route}/$currentIndex")
}