package com.chocolate.triviatitans.ui.screens.level

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

private const val ROUTE = "levelScreen"

fun NavGraphBuilder.navigateToLevel(navController: NavController) {
    composable("$ROUTE/") { LevelScreen(navController = navController) }
}