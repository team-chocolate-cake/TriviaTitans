package com.chocolate.triviatitans

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.chocolate.triviatitans.presentation.Screens
import com.chocolate.triviatitans.presentation.screens.category.CategoryScreen
import com.chocolate.triviatitans.presentation.screens.home.HomeScreen
import com.chocolate.triviatitans.presentation.screens.level.LevelScreen
import com.chocolate.triviatitans.presentation.screens.quiz_screen.QuizScreen

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

        composable(
            "${Screens.LevelScreen.route}/{categories}/{game_type}",
            arguments = listOf(
                navArgument("categories") { NavType.StringType },
                navArgument("game_type") { NavType.IntType }
            )
        ) {
            LevelScreen(navController = navController)
        }

        /*composable(
            "${Screens.QuizScreen.route}/{categories}/{game_type}/{level_type}",
            arguments = listOf(
                navArgument("categories") { NavType.StringType },
                navArgument("game_type") { NavType.IntType },
                navArgument("level_type") { NavType.StringType }
            )
        ) {
            QuizScreen(navController = navController)
        }*/

    }
}
