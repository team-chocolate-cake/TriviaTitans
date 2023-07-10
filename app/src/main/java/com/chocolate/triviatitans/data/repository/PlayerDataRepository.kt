package com.chocolate.triviatitans.data.repository

import com.chocolate.triviatitans.data.local.PlayerData

interface PlayerDataRepository {
    suspend fun savePlayerData(playerData: PlayerData)
}