package com.example.newsapi.models

import com.example.newsapi.models.Article

data class News(
    val articles: ArrayList<Article>,
    val status: String,
    val totalResults: Int
)

data class Source(
    val id: String,
    val name: String
)