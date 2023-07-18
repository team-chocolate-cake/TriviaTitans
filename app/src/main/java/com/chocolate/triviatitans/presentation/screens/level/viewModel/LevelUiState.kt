package com.chocolate.triviatitans.presentation.screens.level.viewModel

data class LevelUiState(
    val selectedLevel: TypeLevel = TypeLevel.Easy,
    val score: ScoreByLevel = ScoreByLevel(),
)

data class ScoreByLevel(
    val easy:Int = 0,
    val medium:Int = 0,
    val hard:Int = 0,

)
enum class TypeLevel(name: String) {
    Easy("easy"),
    Medium("medium"),
    Hard("hard")
}
