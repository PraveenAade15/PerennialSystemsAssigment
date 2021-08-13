package com.example.perennialsystems

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.perennialsystems.Adapter.UserAdapter
import com.example.perennialsystems.Model.Data
import com.example.perennialsystems.viewmodel.UserViewModel
import java.util.Collections.emptyList

class MainActivity : AppCompatActivity() {
    private lateinit var userViewModel: UserViewModel
    private lateinit var userAdapter: UserAdapter
    private val dataModelList = emptyList<Data>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        setRecyclerAdapter()
        observeLiveData()
        userViewModel.callAPI()
    }
    private fun observeLiveData() {
        userViewModel.liveData.observe(this, {
            when (it) {
                is UserUIModel.Success -> {
                    userAdapter.updateList(it.dataModelList)
                }

                is UserUIModel.Failure -> {
                    Toast.makeText(
                        this@MainActivity,
                        "Error message ${it.error}",
                        Toast.LENGTH_SHORT
                    ).show()

                }
            }
        })
    }

    private fun setRecyclerAdapter() {
        userAdapter = UserAdapter(dataModelList)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.apply {
            this.layoutManager = layoutManager
            adapter = userAdapter
        }
    }