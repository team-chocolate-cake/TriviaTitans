package com.chocolate.triviatitans.data.repository

import com.chocolate.triviatitans.data.remote.service.TriviaTitansService
import com.chocolate.triviatitans.domain.entities.ImageChoiceEntity
import com.chocolate.triviatitans.domain.entities.TextChoiceEntity
import com.chocolate.triviatitans.domain.mapper.iamge_choice.DomainImageChoiceMapper
import com.chocolate.triviatitans.domain.mapper.text_choice.DomainTextChoiceMapper
import javax.inject.Inject

class TriviaTitansRepositoryImpl @Inject constructor(
    private val triviaTitansService: TriviaTitansService,
    private val domainImageChoiceEntity: DomainImageChoiceMapper,
    private val domainTextChoiceEntity: DomainTextChoiceMapper
) : TriviaTitansRepository {
    override suspend fun getTextChoiceQuestions(
        limit: Int,
        categories: String,
        difficulties: String
    ): List<TextChoiceEntity> {
        val response = triviaTitansService.getTextChoiceQuestion(limit, categories, difficulties).body()?: emptyList()
        return domainTextChoiceEntity.map(response)
    }

    override suspend fun getImageChoiceQuestions(
        limit: Int,
        categories: String,
        difficulties: String
    ): List<ImageChoiceEntity> {
        val response = triviaTitansService.getImageChoiceQuestion(limit, categories, difficulties).body()?: emptyList()
        return domainImageChoiceEntity.map(response)

    }

}