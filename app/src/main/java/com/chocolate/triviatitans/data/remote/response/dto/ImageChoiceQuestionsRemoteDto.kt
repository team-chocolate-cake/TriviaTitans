package com.chocolate.triviatitans.data.remote.response.dto


import com.google.gson.annotations.SerializedName

data class ImageChoiceQuestionsRemoteDto(
    @SerializedName("category")
    val category: String?,
    @SerializedName("correctAnswer")
    val correctAnswer: List<CorrectAnswer>?,
    @SerializedName("difficulty")
    val difficulty: String?,
    @SerializedName("id")
    val id: String?,
    @SerializedName("incorrectAnswers")
    val incorrectAnswers: List<List<IncorrectAnswer>>?,
    @SerializedName("isNiche")
    val isNiche: Boolean?,
    @SerializedName("question")
    val question: Question?,
    @SerializedName("regions")
    val regions: List<String>?,
    @SerializedName("tags")
    val tags: List<String>?,
    @SerializedName("type")
    val type: String?
)