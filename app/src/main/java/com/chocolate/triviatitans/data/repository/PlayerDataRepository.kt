package com.chocolate.triviatitans.data.repository

interface PlayerDataRepository {
    suspend fun savePlayerData(dataType: PlayerDataType, prize: Int)
}