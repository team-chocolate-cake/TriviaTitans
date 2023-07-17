package com.chocolate.triviatitans.presentation.screens.home

data class HomeUiState(
    val homeCards:List<HomeCardState> = emptyList(),
    val selectedGameType: GameType? = null
)

data class HomeCardState(
    val gameType: GameType,
    val description: String = "",
    val image: Int = 0,
)
