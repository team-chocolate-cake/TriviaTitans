package com.chocolate.triviatitans.presentation.screens.level.level

data class LevelUiState(
    val selectedLevel: TypeLevel = TypeLevel.Easy,
    val score: Int = 10,
)
enum class TypeLevel(name: String) {
    Easy("easy"),
    Medium("medium"),
    Hard("hard")
}
