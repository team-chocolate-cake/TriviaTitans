package com.chocolate.triviatitans.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query



@Dao
interface TriviaDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPlayerData(playerData: LocalPlayerDataDto)

    @Query("SELECT * FROM player_data LIMIT 1")
    suspend fun getPlayerData(): PlayerData
}

