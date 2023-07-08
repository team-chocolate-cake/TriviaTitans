package com.chocolate.triviatitans.presentation.screens.home

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.chocolate.triviatitans.presentation.Screens
import com.chocolate.triviatitans.presentation.screens.word_wise_screen.WordWiseScreen

fun NavGraphBuilder.homeRoute(navController: NavHostController){
    composable(route = Screens.HomeScreen.route){
        WordWiseScreen(navController)
    }
}