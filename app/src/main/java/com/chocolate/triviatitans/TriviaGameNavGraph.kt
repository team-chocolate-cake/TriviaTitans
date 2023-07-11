package com.chocolate.triviatitans

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.chocolate.triviatitans.presentation.Screens
import com.chocolate.triviatitans.presentation.screens.category.categoryRoute
import com.chocolate.triviatitans.presentation.screens.home.homeRoute
import com.chocolate.triviatitans.presentation.screens.level.LevelScreen
import com.chocolate.triviatitans.presentation.screens.level.levelRoute
import com.chocolate.triviatitans.presentation.screens.quiz_screen.QuizScreen
import com.chocolate.triviatitans.presentation.screens.quiz_screen.quizRoute
import com.chocolate.triviatitans.presentation.screens.win_lose_screens.LoseScreen
import com.chocolate.triviatitans.presentation.screens.win_lose_screens.SpinWheelScreen
import com.chocolate.triviatitans.presentation.screens.win_lose_screens.WinScreen
import com.chocolate.triviatitans.presentation.screens.win_lose_screens.loseRoute
import com.chocolate.triviatitans.presentation.screens.win_lose_screens.spinWheelRoute
import com.chocolate.triviatitans.presentation.screens.win_lose_screens.winRoute

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
    }
}