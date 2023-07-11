package com.chocolate.triviatitans.presentation.screens.category

import android.util.Log
import androidx.lifecycle.SavedStateHandle
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
/*

class CategoryArgs(savedStateHandle: SavedStateHandle) {
    val currentIndex: Int = checkNotNull(savedStateHandle[Games_ARGS])

    companion object {
        const val Games_ARGS = "currentIndex"
    }
}

*/

