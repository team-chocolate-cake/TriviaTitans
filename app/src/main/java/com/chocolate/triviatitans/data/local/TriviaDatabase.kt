package com.chocolate.triviatitans.data.local

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(
    entities = [LocalPlayerDataDto::class],
    version = 1,
    exportSchema = false
)
abstract class TriviaDatabase : RoomDatabase() {
    abstract val triviaDao: TriviaDao
}