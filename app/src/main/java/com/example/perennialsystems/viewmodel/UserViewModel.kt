package com.example.perennialsystems.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.perennialsystems.Model.Data
import retrofit2.Callback
import com.example.perennialsystems.Model.Response
import com.example.perennialsystems.repository.UserRepository
import retrofit2.Call

class UserViewModel : ViewModel(), Callback<Response> {

    private val repository = UserRepository(this)

    private val mutableLiveData = MutableLiveData<Data>()

    val liveData: LiveData<Data> = mutableLiveData


    override fun onResponse(call: Call<Response>, response: Response<Response>) {
        response.body()?.let {
            mutableLiveData.value = Data.Success(it.data as List<Data>)
        }
    }


    override fun onFailure(call: Call<Response>, t: Throwable) {
        mutableLiveData.value = Data.Failure(t.message!!)
    }


    fun callAPI() {
        repository.getListOfModel()
    }

}