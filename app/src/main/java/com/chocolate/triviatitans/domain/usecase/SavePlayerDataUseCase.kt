package com.chocolate.triviatitans.domain.usecase

import com.chocolate.triviatitans.data.local.PlayerData
import com.chocolate.triviatitans.data.repository.PlayerDataRepository
import javax.inject.Inject

class SavePlayerDataUseCase @Inject constructor(
    private val playerDataRepository: PlayerDataRepository
) {
    suspend fun savePlayerData(playerData: PlayerData) {
        playerDataRepository.savePlayerData(playerData)
    }
}