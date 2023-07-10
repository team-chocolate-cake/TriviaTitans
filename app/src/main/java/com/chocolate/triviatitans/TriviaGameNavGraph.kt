package com.chocolate.triviatitans

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.chocolate.triviatitans.presentation.Screens
import com.chocolate.triviatitans.presentation.screens.category.CategoryScreen
import com.chocolate.triviatitans.presentation.screens.category.categoryRoute
import com.chocolate.triviatitans.presentation.screens.home.HomeScreen
import com.chocolate.triviatitans.presentation.screens.home.homeRoute
import com.chocolate.triviatitans.presentation.screens.level.LevelScreen
import com.chocolate.triviatitans.presentation.screens.level.levelRoute
import com.chocolate.triviatitans.presentation.screens.quiz_screen.QuizScreen
import com.chocolate.triviatitans.presentation.screens.win_lose_screens.LoseScreen
import com.chocolate.triviatitans.presentation.screens.win_lose_screens.SpinWheelScreen
import com.chocolate.triviatitans.presentation.screens.win_lose_screens.WinScreen

@Composable
fun TriviaNavGraph() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screens.HomeScreen.route
    )
    {
        homeRoute(navController)
        categoryRoute(navController)
        levelRoute(navController)
        composable(
            "${Screens.LevelScreen.route}/{categories}/{game_type}",
            arguments = listOf(
                navArgument("categories") { NavType.StringType },
                navArgument("game_type") { NavType.IntType }
            )
        ) {
            LevelScreen(navController = navController)
        }

        composable(
            "${Screens.QuizScreen.route}/{categories}/{game_type}/{level_type}",
            arguments = listOf(
                navArgument("categories") { NavType.StringType },
                navArgument("game_type") { NavType.IntType },
                navArgument("level_type") { NavType.StringType }
            )
        ) {
            QuizScreen(navController = navController)
        }

        composable(Screens.SpinWheelScreen.route) {
            SpinWheelScreen(navController = navController)
        }

      /*  composable(
            "${Screens.WinScreen.route}/{prize}",
            arguments = listOf(
                navArgument("prize") { NavType.StringType }
            )
        ) {
            WinScreen(navController = navController)
        }*/

        composable(
            "${Screens.WinScreen.route}/{prize}",
            arguments = listOf(
                navArgument("prize") { NavType.StringType }
            )
        ) { backStackEntry ->
            val prize = backStackEntry.arguments?.getString("prize") ?: ""
            WinScreen(navController = navController, prize = prize)
        }


        composable(Screens.LoseScreen.route) {
            LoseScreen(navController = navController)
        }

    }
}
