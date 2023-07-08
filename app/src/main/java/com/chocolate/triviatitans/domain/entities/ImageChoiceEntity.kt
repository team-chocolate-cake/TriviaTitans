package com.chocolate.triviatitans.domain.entities

data class ImageChoiceEntity(
    val id: String,
    val category: String,
    val correctAnswer: List<CorrectAnswerImageEntity>,
    val incorrectAnswer: List<List<String?>>,
    val question: String,
    val difficulty: String
){
    val _correctAnswer = correctAnswer[0].imageUrl
    val _incorrectAnswer = incorrectAnswer[0]?: emptyList()
}