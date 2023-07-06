package com.chocolate.triviatitans.domain.mapper.iamge_choice

import com.chocolate.triviatitans.data.remote.response.dto.CorrectAnswer
import com.chocolate.triviatitans.data.remote.response.dto.IncorrectAnswer
import com.chocolate.triviatitans.domain.entities.CorrectAnswerImageEntity
import com.chocolate.triviatitans.domain.entities.InCorrectAnswerImageEntity
import com.chocolate.triviatitans.domain.mapper.Mapper
import javax.inject.Inject

class DomainCorrectAnswerDto @Inject constructor() : Mapper<CorrectAnswer, CorrectAnswerImageEntity> {
    override fun map(input: CorrectAnswer): CorrectAnswerImageEntity {
        return CorrectAnswerImageEntity(
            imageUrl = input.url ?: ""
        )
    }
}