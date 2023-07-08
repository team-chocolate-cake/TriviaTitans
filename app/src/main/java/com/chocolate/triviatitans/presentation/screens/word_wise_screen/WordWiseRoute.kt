package com.chocolate.triviatitans.presentation.screens.word_wise_screen

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.chocolate.triviatitans.presentation.Screens

fun NavGraphBuilder.wordWiseRoute(navController: NavHostController){
    composable(route =Screens.WordWiseScreen.route){
        WordWiseScreen(navController)
    }
}
