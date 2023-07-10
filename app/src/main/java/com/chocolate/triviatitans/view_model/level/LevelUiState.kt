package com.chocolate.triviatitans.view_model.level

data class LevelUiState(
    val selectedLevel: TypeLevel = TypeLevel.Easy,
    val score: Int = 10,
)
enum class TypeLevel(name: String) {
    Easy("easy"),
    Medium("medium"),
    Hard("hard")
}
