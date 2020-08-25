package com.example.newsapi.models

data class Article(
    val author: String,
    val description: String,
    val title: String,
    val urlToImage: String?
)