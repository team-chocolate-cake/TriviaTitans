package com.chocolate.triviatitans.data.remote.response.dto


import com.google.gson.annotations.SerializedName

data class Source(
    @SerializedName("url")
    val url: String?
)