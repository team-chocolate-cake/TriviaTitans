package com.chocolate.triviatitans.presentation.screens.category

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.chocolate.triviatitans.presentation.Screens
import com.chocolate.triviatitans.presentation.screens.category.CategoryArgs.Companion.CURRENT_INDEX

fun NavGraphBuilder.categoryRoute(navController: NavController) {
    composable(
        "${Screens.CategoryScreen.route}/{$CURRENT_INDEX}",
        arguments = listOf(
            navArgument(CURRENT_INDEX) { NavType.IntType}
        )) {
        CategoryScreen(navController = navController)
    }
}

fun NavController.navigateToCategory(currentIndex: Int) {
    navigate("${Screens.CategoryScreen.route}/$currentIndex")
}

class CategoryArgs(savedStateHandle: SavedStateHandle){
    val currentIndex = checkNotNull(savedStateHandle[CURRENT_INDEX])
    companion object{
        const val CURRENT_INDEX = "currentIndex"
    }
}