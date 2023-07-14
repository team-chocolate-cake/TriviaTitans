package com.chocolate.triviatitans.domain.usecase

import com.chocolate.triviatitans.data.repository.PlayerDataRepository
import com.chocolate.triviatitans.data.repository.PlayerDataType
import javax.inject.Inject

class SavePlayerDataUseCase @Inject constructor(
    private val playerDataRepository: PlayerDataRepository
) {
    suspend fun savePlayerData(dataType: PlayerDataType, prize: Int) {
        playerDataRepository.savePlayerData(dataType, prize)
    }
}