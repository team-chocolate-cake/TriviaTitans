package com.chocolate.triviatitans.data.repository

import com.chocolate.triviatitans.data.local.TriviaDao
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