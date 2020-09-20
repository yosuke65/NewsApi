package com.example.newsapi.main

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapi.databinding.RowNewsListBinding
import com.example.newsapi.models.Article
import kotlinx.android.synthetic.main.row_news_list.view.*

class AdapterNewsList():RecyclerView.Adapter<AdapterNewsList.MyViewHolder>() {

    companion object{
        private const val TAG = "AdapterNewsList"
    }

    private var mList = ArrayList<Article>()
    private var statusLiveData = MutableLiveData<Article>()

    inner class MyViewHolder(private val binding:RowNewsListBinding):RecyclerView.ViewHolder(binding.root),View.OnClickListener{
        fun bind(article: Article){
            binding.item = article
            binding.executePendingBindings()
            itemView.setOnClickListener(this)
        }

        override fun onClick(view: View) {
            Log.d(TAG, "onClick: ${view.text_view_author}")
            statusLiveData.postValue(mList[adapterPosition])
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

    fun getStatusLiveData() = statusLiveData

}