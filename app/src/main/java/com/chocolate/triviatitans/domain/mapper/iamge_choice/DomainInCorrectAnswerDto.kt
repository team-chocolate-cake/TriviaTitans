package com.chocolate.triviatitans.domain.mapper.iamge_choice

import com.chocolate.triviatitans.data.remote.response.dto.IncorrectAnswer
import com.chocolate.triviatitans.domain.entities.InCorrectAnswerImageEntity
import com.chocolate.triviatitans.domain.mapper.Mapper
import javax.inject.Inject

class DomainInCorrectAnswerDto @Inject constructor() :
    Mapper<IncorrectAnswer, InCorrectAnswerImageEntity> {
    override fun map(input: IncorrectAnswer): InCorrectAnswerImageEntity {
        return InCorrectAnswerImageEntity(
            imageUrl = input.url ?: ""
        )
    }
}