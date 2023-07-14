package com.chocolate.triviatitans.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "player_data")
data class LocalPlayerDataDto(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "bonus") val bonus: Int,
    @ColumnInfo(name = "delete_two_answers") val deleteTwoAnswers: Int,
    @ColumnInfo(name = "change_question") val changeQuestion: Int,
    @ColumnInfo(name = "hearts") val hearts: Int,
    @ColumnInfo(name = "easy_score") val easyScore: Int,
    @ColumnInfo(name = "medium_score") val mediumScore: Int,
    @ColumnInfo(name = "hard_score") val hardScore: Int,
)