package com.example.newsapi.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Article(
    val author: String,
    val description: String,
    val title: String,
    val urlToImage: String?
) : Parcelable