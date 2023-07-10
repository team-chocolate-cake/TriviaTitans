package com.chocolate.triviatitans.data.local

import androidx.room.ColumnInfo
import androidx.room.Database
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.RoomDatabase


@Database(
    entities = [PlayerData::class],
    version = 1,
    exportSchema = false
)
abstract class TriviaDatabase : RoomDatabase() {
    abstract val triviaDao: TriviaDao
}

@Entity(tableName = "player_data")
data class PlayerData(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "bonus") val bonus: Int,
    @ColumnInfo(name = "delete_two_answers") val deleteTwoAnswers: Int,
    @ColumnInfo(name = "change_question") val changeQuestion: Int,
    @ColumnInfo(name = "hearts") val hearts: Int
)
