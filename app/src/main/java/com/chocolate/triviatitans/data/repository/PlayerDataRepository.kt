package com.chocolate.triviatitans.data.repository

import com.chocolate.triviatitans.data.local.LocalPlayerDataDto
import com.chocolate.triviatitans.presentation.screens.PlayerDataType

interface PlayerDataRepository {
    suspend fun savePlayerData(dataType: PlayerDataType, prize: Int)
    suspend fun getPlayerData() : LocalPlayerDataDto
}