package com.example.newsapi.main

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapi.databinding.RowNewsListBinding
import com.example.newsapi.models.Article

class AdapterNewsList:RecyclerView.Adapter<AdapterNewsList.MyViewHolder>() {

    private var mList = ArrayList<Article>()

    inner class MyViewHolder(private val binding:RowNewsListBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(article: Article){
            binding.item = article
            binding.executePendingBindings()
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = RowNewsListBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        val layoutParams = RecyclerView.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,RelativeLayout.LayoutParams.WRAP_CONTENT)
        binding.root.layoutParams = layoutParams
        return MyViewHolder(binding)
    }

    override fun getItemCount() = mList.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(mList[position])
    }

    fun setData(list:ArrayList<Article>){
        mList = list
        notifyDataSetChanged()
    }
}