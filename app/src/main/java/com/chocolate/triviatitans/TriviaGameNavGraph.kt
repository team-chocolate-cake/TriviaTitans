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
import com.chocolate.triviatitans.presentation.screens.win_lose_screens.LoseScreen
import com.chocolate.triviatitans.presentation.screens.win_lose_screens.SpinWheelScreen
import com.chocolate.triviatitans.presentation.screens.win_lose_screens.WinScreen

@Composable
fun TriviaNavGraph() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screens.HomeScreen.route) {
        homeRoute(navController)
        categoryRoute(navController)
        levelRoute(navController)
        quizRoute(navController)
        loseRoute(navController)
        spinWheelRoute(navController)
        winRoute(navController)

        composable(
            "${Screens.WinScreen.route}/{prize}/{prize_type}",
            arguments = listOf(
                navArgument("prize") { NavType.IntType },
                navArgument("prize_type") { NavType.StringType }
            )
        ) { WinScreen(navController = navController) }
}