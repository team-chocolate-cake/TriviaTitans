package com.chocolate.triviatitans.data.repository

import com.chocolate.triviatitans.data.local.LocalPlayerDataDto
import com.chocolate.triviatitans.domain.entities.PlayerDataEntity

interface PlayerDataRepository {
    suspend fun savePlayerData(localPlayerDataDto: PlayerDataEntity)
}