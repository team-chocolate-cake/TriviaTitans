package com.chocolate.triviatitans.domain.mapper.player_data

import com.chocolate.triviatitans.data.local.LocalPlayerDataDto
import com.chocolate.triviatitans.domain.entities.PlayerDataEntity
import com.chocolate.triviatitans.domain.mapper.Mapper
import javax.inject.Inject

class DomainPlayerDataMapper @Inject constructor() :
    Mapper<LocalPlayerDataDto, PlayerDataEntity> {
    override fun map(input: LocalPlayerDataDto): PlayerDataEntity {
        return PlayerDataEntity(
            id = input.id,
            bonus = input.bonus,
            deleteTwoAnswers = input.deleteTwoAnswers,
            changeQuestion = input.changeQuestion,
            hearts = input.hearts,
            easyScore = input.easyScore,
            mediumScore =input.mediumScore ,
            hardScore = input.hardScore
        )
    }
}