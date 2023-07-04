package com.chocolate.triviatitans.data.remote.service

import com.chocolate.triviatitans.data.remote.response.dto.ImageChoiceQuestionsRemoteDto
import com.chocolate.triviatitans.data.remote.response.dto.TextChoiceQuestionsRemoteDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TriviaTitansService {

    /// region image choice question
    @GET("questions")
    suspend fun getImageChoiceQuestion(
        @Query("limit") limit: Int,
        @Query("categories") categories: String,
        @Query("difficulties") difficulties: String,
        @Query("types") types: String = "image_choice"
    ): Response<List<ImageChoiceQuestionsRemoteDto>?>

    /// endregion

    /// region image choice question
    @GET("questions")
    suspend fun getTextChoiceQuestion(
        @Query("limit") limit: Int,
        @Query("categories") categories: String,
        @Query("difficulties") difficulties: String,
        @Query("types") types: String = "text_choice"
    ): Response<List<TextChoiceQuestionsRemoteDto>>

    /// endregion



}