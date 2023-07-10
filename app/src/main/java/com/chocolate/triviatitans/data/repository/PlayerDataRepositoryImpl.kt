package com.chocolate.triviatitans.data.repository

import com.chocolate.triviatitans.data.local.PlayerData
import com.chocolate.triviatitans.data.local.TriviaDao
import javax.inject.Inject

class PlayerDataRepositoryImpl @Inject constructor(
    private val triviaDao: TriviaDao
) : PlayerDataRepository {
    override suspend fun savePlayerData(playerData: PlayerData) {
        triviaDao.insertPlayerData(playerData)
    }
}