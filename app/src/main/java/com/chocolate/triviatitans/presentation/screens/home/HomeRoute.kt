package com.chocolate.triviatitans.presentation.screens.home

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.chocolate.triviatitans.presentation.Screens

fun NavGraphBuilder.homeRoute(navController: NavController){
    composable(route = Screens.HomeScreen.route){
        HomeScreen(navController)
    }
}