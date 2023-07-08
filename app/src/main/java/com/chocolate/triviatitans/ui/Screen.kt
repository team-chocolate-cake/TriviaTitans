package com.chocolate.triviatitans.ui

sealed class Screen(val route: String){
    object LevelScreen: Screen("levelScreen")
}
