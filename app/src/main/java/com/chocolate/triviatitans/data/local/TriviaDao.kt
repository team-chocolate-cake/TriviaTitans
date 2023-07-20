package com.chocolate.triviatitans.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update


@Dao
interface TriviaDao {
    @Query("SELECT * FROM player_data")
    suspend fun getPlayerData(): LocalPlayerDataDto?

    @Insert
    suspend fun insertPlayerData(localPlayerDataDto: LocalPlayerDataDto)

    @Query("UPDATE player_data SET bonus = bonus + :newBonus")
    suspend fun updateBonus(newBonus: Int)

    @Query("UPDATE player_data SET hearts = hearts + :newHearts")
    suspend fun updateHearts(newHearts: Int)

    @Query("UPDATE player_data SET change_question = change_question + :newChangeQuestion")
    suspend fun updateChangeQuestions(newChangeQuestion: Int)

    @Query("UPDATE player_data SET delete_two_answers = delete_two_answers + :newDeleteTwoAnswers")
    suspend fun updateDeleteTwoAnswers(newDeleteTwoAnswers: Int)

    @Query("UPDATE player_data SET easy_score = easy_score + :newScore")
    suspend fun updateEasyScore(newScore: Int)
    @Query("UPDATE player_data SET medium_score = medium_score + :newScore")
    suspend fun updateMediumScore(newScore: Int)
    @Query("UPDATE player_data SET hard_score = hard_score + :newScore")
    suspend fun updateHardScore(newScore: Int)

}


