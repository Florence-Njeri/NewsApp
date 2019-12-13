package com.example.newsapp.data

/**
 * New data class
 */
data class Thumbnail(

    val thumbnail: String
)

data class Base(

    val response: NewsResponse
)

data class NewsResponse(
    val results: List<NewsResults>
)

data class NewsResults(

    val type: String,
    val sectionName: String,
    val webPublicationDate: String,
    val webTitle: String,
    val webUrl: String,
    val thumbNail: Thumbnail
)
