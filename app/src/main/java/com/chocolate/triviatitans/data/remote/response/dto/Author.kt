package com.chocolate.triviatitans.data.remote.response.dto


import com.google.gson.annotations.SerializedName

data class Author(
    @SerializedName("name")
    val name: String?,
    @SerializedName("url")
    val url: String?
)