package com.chocolate.triviatitans.usecase

import com.chocolate.triviatitans.data.repository.TriviaTitansRepository
import com.chocolate.triviatitans.domain.entities.TextChoiceEntity
import javax.inject.Inject

class GetUserQuestionsUseCase @Inject constructor(
    private val repository: TriviaTitansRepository,
) {

    suspend operator fun invoke(
        limit: Int,
        categories: String,
        difficulties: String,
    ): List<TextChoiceEntity> {
        return repository.getTextChoiceQuestions(limit, categories, difficulties)
    }
}