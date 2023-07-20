package com.chocolate.triviatitans.presentation

sealed class Screens(val route: String){
    object HomeScreen: Screens("HomeScreen")
    object CategoryScreen: Screens("CategoryScreen")
    object LevelScreen: Screens("LevelScreen")
    object ImageGameScreen: Screens("ImageGameScreen")
    object TextGameScreen: Screens("TextGameScreen")
    object WordWiseScreen: Screens("WordWiseScreen")
    object SpinWheelScreen: Screens("SpinWheelScreen")
    object WinScreen: Screens("WinScreen")
    object LoseScreen: Screens("LoseScreen")
    object SplashScreen: Screens("SplashScreen")

}
