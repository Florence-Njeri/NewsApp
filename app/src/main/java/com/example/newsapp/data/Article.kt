package com.example.newsapp.data


import com.squareup.moshi.Json

data class Article(
    @Json(name = "author")
    val author: String?,
    @Json(name = "description")
    val description: String?,
    @Json(name = "publishedAt")
    val publishedAt: String?,
    @Json(name = "title")
    val title: String?,
    @Json(name = "url")
    val url: String?,
    @Json(name = "urlToImage")
    val urlToImage: String?
)
