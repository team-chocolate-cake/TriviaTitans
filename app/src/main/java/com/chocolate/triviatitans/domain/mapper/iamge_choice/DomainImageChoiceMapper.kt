package com.chocolate.triviatitans.domain.mapper.iamge_choice

import com.chocolate.triviatitans.data.remote.response.dto.ImageChoiceQuestionsRemoteDto
import com.chocolate.triviatitans.domain.entities.ImageChoiceEntity
import com.chocolate.triviatitans.domain.mapper.Mapper
import javax.inject.Inject

class DomainImageChoiceMapper @Inject constructor(
    private val domainCorrectAnswerDto: DomainCorrectAnswerDto,
    private val domainInCorrectAnswerDto: DomainInCorrectAnswerDto
) :
    Mapper<ImageChoiceQuestionsRemoteDto, ImageChoiceEntity> {
    override fun map(input: ImageChoiceQuestionsRemoteDto): ImageChoiceEntity {
        return ImageChoiceEntity(
            id = input.id ?: "",
            category = input.category ?: "",
            correctAnswer = domainCorrectAnswerDto.mapSingle(input.correctAnswer ?: emptyList()),
            incorrectAnswer = domainInCorrectAnswerDto.mapNested(input.incorrectAnswers ?: emptyList()) ,
            question = (input.question ?: "") as String,
            difficulty = input.difficulty ?: ""
        )
    }
}

