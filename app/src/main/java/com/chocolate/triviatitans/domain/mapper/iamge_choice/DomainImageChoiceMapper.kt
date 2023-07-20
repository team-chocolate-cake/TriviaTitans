package com.chocolate.triviatitans.domain.mapper.iamge_choice

import com.chocolate.triviatitans.data.remote.response.dto.ImageChoiceQuestionsRemoteDto
import com.chocolate.triviatitans.domain.entities.ImageChoiceEntity
import com.chocolate.triviatitans.domain.mapper.Mapper
import javax.inject.Inject

class DomainImageChoiceMapper @Inject constructor(
    private val domainCorrectAnswerDto: DomainCorrectAnswerDto,
) :
    Mapper<ImageChoiceQuestionsRemoteDto, ImageChoiceEntity> {
    override fun map(input: ImageChoiceQuestionsRemoteDto): ImageChoiceEntity {
        return ImageChoiceEntity(
            id = input.id ?: "",
            category = input.category ?: "",
            correctAnswer = domainCorrectAnswerDto.mapSingle(input.correctAnswer ?: emptyList()),
            incorrectAnswer = input.incorrectAnswers?.map { inCorrectAnswers ->
                inCorrectAnswers[0].url ?: ""
            } ?: emptyList(),
            question = input.question?.text ?: "",
            difficulty = input.difficulty ?: ""
        )
    }
}