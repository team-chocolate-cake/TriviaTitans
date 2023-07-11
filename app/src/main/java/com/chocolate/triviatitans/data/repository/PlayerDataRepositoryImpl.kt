package com.chocolate.triviatitans.data.repository

import com.chocolate.triviatitans.data.local.TriviaDao
import com.chocolate.triviatitans.domain.entities.PlayerDataEntity
import com.chocolate.triviatitans.domain.mapper.player_data.DomainPlayerDataMapper
import javax.inject.Inject

class PlayerDataRepositoryImpl @Inject constructor(
    private val triviaDao: TriviaDao,
    private val domainPlayerDataMapper: DomainPlayerDataMapper
) : PlayerDataRepository, BaseRepository() {
    override suspend fun savePlayerData(localPlayerDataDto: PlayerDataEntity) {
        triviaDao.insertPlayerData(domainPlayerDataMapper.map(localPlayerDataDto))
    }
}