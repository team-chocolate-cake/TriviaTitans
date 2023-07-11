package com.chocolate.triviatitans.domain.usecase

import com.chocolate.triviatitans.data.repository.PlayerDataRepository
import com.chocolate.triviatitans.domain.entities.PlayerDataEntity
import javax.inject.Inject

class SavePlayerDataUseCase @Inject constructor(
    private val playerDataRepository: PlayerDataRepository
) {
    suspend fun savePlayerData(playerDataEntity: PlayerDataEntity) {
        playerDataRepository.savePlayerData(playerDataEntity)
    }
}