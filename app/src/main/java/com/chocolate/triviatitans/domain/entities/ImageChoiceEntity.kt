package com.chocolate.triviatitans.domain.entities

data class ImageChoiceEntity(
    val id: String,
    val category: String,
    val correctAnswer: List<CorrectAnswerImageEntity>,
    val incorrectAnswer: List<String>,
    val question: String,
    val difficulty: String
)