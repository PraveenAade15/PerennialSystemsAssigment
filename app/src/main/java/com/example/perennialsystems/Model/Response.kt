package com.example.perennialsystems.Model


import com.google.gson.annotations.SerializedName

data class Response(
    @SerializedName("data")
    val `data`: List<Data>,
    @SerializedName("message")
    val message: String,
    @SerializedName("status")
    val status: String
)