package com.example.perennialsystems.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.perennialsystems.Model.Data
import com.example.perennialsystems.R

class UserAdapter : RecyclerView.Adapter<UserAdapter.ArticleViewHolder>(){

    inner class ArticleViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    //create a list of item and notify data set change it will create two method in background
    private val differCallback=object : DiffUtil.ItemCallback<Data>(){
        override fun areItemsTheSame(oldItem: Data, newItem:Data): Boolean {
            return oldItem.id==newItem.id


        }

        override fun areContentsTheSame(oldItem: Data, newItem: Data): Boolean {
            return oldItem==newItem

        }

    }
    //asynch list differ
    val differ= AsyncListDiffer(this,differCallback)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        return ArticleViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_layout,parent,false
            )

        )

    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val article=differ.currentList[position]
        holder.itemView.apply {
            val tvid = null
            tvid.text=article.id
            tvName.text=article.employeeName
           tvAge.text=article.employeeSalary
            tvSalary.text=article.employeeAge


        }


    }

    override fun getItemCount(): Int {
        return differ.currentList.size

    }


}
