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
) : TriviaTitansRepository, BaseRepository() {
    override suspend fun getTextChoiceQuestions(
        limit: Int,
        categories: String,
        difficulties: String
    ): List<TextChoiceEntity> {
       val textChoiceRemoteDTOs =  wrapApiCall {  triviaTitansService.getTextChoiceQuestion(limit, categories, difficulties)}
        return domainTextChoiceEntity.map(textChoiceRemoteDTOs)
    }

    override suspend fun getImageChoiceQuestions(
        limit: Int,
        categories: String,
        difficulties: String
    ): List<ImageChoiceEntity> {
        val imageChoiceRemoteDTOs = wrapApiCall {  triviaTitansService.getImageChoiceQuestion(limit, categories, difficulties) }
        return domainImageChoiceEntity.map(imageChoiceRemoteDTOs)
    }

}