package com.chocolate.triviatitans.domain.mapper.text_choice

import com.chocolate.triviatitans.data.remote.response.dto.TextChoiceQuestionsRemoteDto
import com.chocolate.triviatitans.domain.entities.TextChoiceEntity
import com.chocolate.triviatitans.domain.mapper.Mapper
import javax.inject.Inject

class DomainTextChoiceMapper @Inject constructor() :
    Mapper<TextChoiceQuestionsRemoteDto, TextChoiceEntity> {
    override fun map(input: TextChoiceQuestionsRemoteDto): TextChoiceEntity {
        return TextChoiceEntity(
            id = input.id ?: "",
            category = input.category ?: "",
            correctAnswer = input.correctAnswer ?: "",
            incorrectAnswer = input.incorrectAnswers ?: listOf(""),
            question = input.question?.text ?: "",
            difficulty = input.difficulty ?: ""
        )
    }
}
