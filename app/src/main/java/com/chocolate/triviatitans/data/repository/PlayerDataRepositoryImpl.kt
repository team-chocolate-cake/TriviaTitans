package com.chocolate.triviatitans.data.repository

import com.chocolate.triviatitans.data.local.LocalPlayerDataDto
import com.chocolate.triviatitans.data.local.TriviaDao
import com.chocolate.triviatitans.presentation.screens.PlayerDataType
import javax.inject.Inject

class PlayerDataRepositoryImpl @Inject constructor(
    private val triviaDao: TriviaDao
) : PlayerDataRepository, BaseRepository() {
    override suspend fun savePlayerData(dataType: PlayerDataType, prize: Int) {
        when (dataType) {
           PlayerDataType.Bonus -> {
                triviaDao.updateBonus(prize)
            }

            PlayerDataType.Hearts -> {
                triviaDao.updateHearts(prize)
            }

            PlayerDataType.DeleteTwoAnswers -> {
                triviaDao.updateDeleteTwoAnswers(prize)
            }

            PlayerDataType.ChangeQuestion -> {
                triviaDao.updateChangeQuestions(prize)
            }
            PlayerDataType.EasyScore -> {
                triviaDao.updateEasyScore(prize)
            }
            PlayerDataType.MediumScore -> {
                triviaDao.updateMediumScore(prize)
            }
            PlayerDataType.HardScore -> {
                triviaDao.updateHardScore(prize)
            }
        }
    }

    override suspend fun getPlayerData(): LocalPlayerDataDto {
        return triviaDao.getPlayerData()
    }
}

