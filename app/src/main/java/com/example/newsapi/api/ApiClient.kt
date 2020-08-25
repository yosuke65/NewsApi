package com.example.newsapi.api

import com.example.newsapi.models.News
import retrofit2.Response
import retrofit2.http.GET

//object ApiClient {
//
//    private val endpoint by lazy {
//        val builder = Retrofit.Builder()
//            .baseUrl(BASE_URL)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//
//        builder.create(Endpoint::class.java)
//    }
//
//    fun getEndpoints() = endpoint
//}

interface Endpoint {
    @GET("top-headlines?sources=techcrunch&apiKey=9113484a059648fd895ab9364dfdc8bc")
    suspend fun getArticleUrl(): Response<News>
}