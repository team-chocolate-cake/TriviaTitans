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
        "${Screens.CategoryScreen.route}/${CategoryArgs.Games_ARGS}",
        arguments = listOf(
            navArgument(CategoryArgs.Games_ARGS) { NavType.IntType}
        )) {
        CategoryScreen(navController = navController)
    }
}
fun NavController.navigateToCategory(selectedGame: Int) {
    Log.e("ToCategory1","navigateToCategory1")
    navigate("${Screens.CategoryScreen.route}/$selectedGame")
    Log.e("ToCategory2","navigateToCategory2")

}

class CategoryArgs(savedStateHandle: SavedStateHandle) {
    val selectedGame: Int = checkNotNull(savedStateHandle[Games_ARGS])

    companion object {
        const val Games_ARGS = "selectedGame"
    }
}


