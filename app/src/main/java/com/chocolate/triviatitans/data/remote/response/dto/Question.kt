package com.chocolate.triviatitans.data.remote.response.dto


import com.google.gson.annotations.SerializedName

data class Question(
    @SerializedName("text")
    val text: String?
)