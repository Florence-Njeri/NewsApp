package com.example.newsapp.database


import com.squareup.moshi.Json

data class NewsResults(
    @Json(name = "articles")
    val articles: List<Article>,
    @Json(name = "status")
    val status: String,
    @Json(name = "totalResults")
    val totalResults: Int
)