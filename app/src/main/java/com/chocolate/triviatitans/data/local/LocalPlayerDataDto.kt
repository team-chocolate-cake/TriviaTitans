package com.chocolate.triviatitans.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "player_data")
data class LocalPlayerDataDto(
    @PrimaryKey val id: Int = 0,
    @ColumnInfo(name = "bonus") val bonus: Int = 0,
    @ColumnInfo(name = "delete_two_answers") val deleteTwoAnswers: Int = 3,
    @ColumnInfo(name = "change_question") val changeQuestion: Int = 3,
    @ColumnInfo(name = "hearts") val hearts: Int = 3,
    @ColumnInfo(name = "easy_score") val easyScore: Int = 0,
    @ColumnInfo(name = "medium_score") val mediumScore: Int = 0,
    @ColumnInfo(name = "hard_score") val hardScore: Int = 0,
)