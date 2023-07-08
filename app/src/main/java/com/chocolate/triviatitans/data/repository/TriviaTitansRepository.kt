package com.chocolate.triviatitans.data.repository

import com.chocolate.triviatitans.domain.entities.ImageChoiceEntity
import com.chocolate.triviatitans.domain.entities.TextChoiceEntity

interface TriviaTitansRepository {

    // region text choice
    suspend fun getTextChoiceQuestions(
        limit: Int,
        categories: String,
        difficulties: String
    ): List<TextChoiceEntity>
    //endregion

    // region image choice
    suspend fun getImageChoiceQuestions(
        limit: Int,
        categories: String,
        difficulties: String
    ): List<ImageChoiceEntity>

}