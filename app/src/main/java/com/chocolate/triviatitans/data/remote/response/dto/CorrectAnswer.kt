package com.chocolate.triviatitans.data.remote.response.dto


import com.google.gson.annotations.SerializedName

data class CorrectAnswer(
    @SerializedName("author")
    val author: Author?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("height")
    val height: Int?,
    @SerializedName("license")
    val license: License?,
    @SerializedName("size")
    val size: Int?,
    @SerializedName("source")
    val source: Source?,
    @SerializedName("url")
    val url: String?,
    @SerializedName("width")
    val width: Int?
)