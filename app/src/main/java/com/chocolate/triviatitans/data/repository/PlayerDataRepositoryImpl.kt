package com.chocolate.triviatitans.data.repository

import android.util.Log
import com.chocolate.triviatitans.data.local.LocalPlayerDataDto
import com.chocolate.triviatitans.data.local.TriviaDao
import com.chocolate.triviatitans.domain.entities.PlayerDataEntity
import com.chocolate.triviatitans.domain.mapper.player_data.DomainPlayerDataMapper
import javax.inject.Inject

class PlayerDataRepositoryImpl @Inject constructor(
    private val triviaDao: TriviaDao
) : PlayerDataRepository, BaseRepository() {
    override suspend fun savePlayerData(prizeType: String, prize: Int) {
        when (prizeType) {
            "bonus" -> {
                triviaDao.updateBonus(prize)
            }

            "hearts" -> {
                triviaDao.updateHearts(prize)
            }

            "deleteTwoAnswers" -> {
                triviaDao.updateDeleteTwoAnswers(prize)
            }

            "changeQuestion" -> {
                triviaDao.updateChangeQuestions(prize)
            }
        }
    }
}