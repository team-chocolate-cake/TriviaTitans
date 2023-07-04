package com.chocolate.triviatitans.domain.entities

data class TextChoiceEntity(
    val id: String,
    val category: String,
    val correctAnswer: String,
    val incorrectAnswer: List<String>,
    val question: String,
    val difficulty: String
)