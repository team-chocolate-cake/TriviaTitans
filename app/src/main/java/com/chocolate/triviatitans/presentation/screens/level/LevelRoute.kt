package com.chocolate.triviatitans.presentation.screens.level

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.chocolate.triviatitans.presentation.Screens
import com.chocolate.triviatitans.presentation.screens.category.LevelArgs.Companion.CATEGORY_ARGS

fun NavGraphBuilder.levelRoute(navController: NavController) {
    composable(
        "${Screens.LevelScreen.route}/${CATEGORY_ARGS}",
        arguments = listOf(
            navArgument(CATEGORY_ARGS) { NavType.StringType }
        )) {
        LevelScreen(navController = navController)
    }
}

