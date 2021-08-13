package com.example.perennialsystems.repository

import com.example.perennialsystems.Model.Response
import com.example.perennialsystems.Network.ApiClient
import com.example.perennialsystems.Network.Network
import retrofit2.Callback

class UserRepository(private val callback: Callback<Response>) {

    fun getListOfModel() {
        val apiClient = Network.getInstance().create(ApiClient::class.java)
        val call = apiClient.getUsers()

        call.enqueue(callback)
    }
}
}