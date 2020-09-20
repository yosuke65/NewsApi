package com.example.newsapi.main

import android.util.Log
import com.example.newsapi.api.Endpoint
import com.example.newsapi.models.Article
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MainRepository(private val endpoint: Endpoint) {

    companion object{
        private const val TAG = "MainRepository"
    }
    suspend fun getArticleFromApi():ArrayList<Article>? {
        Log.d(TAG, "getArticleFromApi")
        return withContext(Dispatchers.IO){
            val response = endpoint.getArticleUrl()
            Log.d(TAG, "getArticleFromApi")
            if(response.isSuccessful){
                response.body()?.articles as ArrayList<Article>
            }else{
                null
            }
        }
    }
}