package com.chocolate.triviatitans.domain.entities


data class PlayerDataEntity(
    val id: Int,
    val bonus: Int,
    val deleteTwoAnswers: Int,
    val changeQuestion: Int,
    val hearts: Int,
    val easyScore:Int,
    val mediumScore:Int,
    val hardScore:Int,
)