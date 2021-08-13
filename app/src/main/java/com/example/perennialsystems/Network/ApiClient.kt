package com.example.perennialsystems.Network

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface ApiClient {
    @GET("/api/v1/employees")
    fun getUser():Call<com.example.perennialsystems.Model.Response>
}