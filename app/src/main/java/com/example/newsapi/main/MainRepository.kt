package com.example.newsapi.main

import com.example.newsapi.api.Endpoint
import com.example.newsapi.models.Article
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MainRepository(private val endpoint: Endpoint) {
    suspend fun getArticleFromApi():ArrayList<Article>? {
        return withContext(Dispatchers.IO){
            val response = endpoint.getArticleUrl()
            if(response.isSuccessful){
                response.body()?.articles as ArrayList<Article>
            }else{
                null
            }
        }
    }
}