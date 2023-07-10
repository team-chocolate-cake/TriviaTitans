package com.chocolate.triviatitans

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.chocolate.triviatitans.presentation.Screens
import com.chocolate.triviatitans.presentation.screens.category.CategoryArgs
import com.chocolate.triviatitans.presentation.screens.category.CategoryScreen
import com.chocolate.triviatitans.presentation.screens.category.categoryRoute
import com.chocolate.triviatitans.presentation.screens.home.HomeScreen
import com.chocolate.triviatitans.presentation.screens.home.homeRoute
import com.chocolate.triviatitans.presentation.screens.level.LevelScreen
import com.chocolate.triviatitans.presentation.screens.level.levelRoute
import com.chocolate.triviatitans.presentation.screens.quiz_screen.quizRoute
import com.chocolate.triviatitans.presentation.screens.word_wise_screen.wordWiseRoute

@Composable
fun TriviaNavGraph() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screens.HomeScreen.route
    )
    {
        composable(Screens.HomeScreen.route) {
            HomeScreen(navController = navController)
        }
        composable(
            "${Screens.CategoryScreen.route}/{currentIndex}",
            arguments = listOf(
                navArgument("currentIndex") { NavType.IntType }
            )
        ) {
            CategoryScreen(navController = navController)
        }

        composable(Screens.LevelScreen.route) {
            LevelScreen(navController = navController)
        }
    }
}
