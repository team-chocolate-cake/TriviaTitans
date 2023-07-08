package com.chocolate.triviatitans.domain.usecase

import com.chocolate.triviatitans.data.repository.TriviaTitansRepository
import com.chocolate.triviatitans.domain.entities.ImageChoiceEntity
import javax.inject.Inject

class GetMultiChoiceImagesGameUseCase @Inject constructor(
    private val gameRepository: TriviaTitansRepository,
) {
    suspend operator fun invoke(
        limit: Int,
        categories: String,
        difficulties: String,
    ): List<ImageChoiceEntity> {
        return gameRepository.getImageChoiceQuestions(
            limit = limit,
            categories = categories,
            difficulties = difficulties
        )
    }
}