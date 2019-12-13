package com.example.newsapp.data

import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

/**
 * New data class
 */
data class Fields(

    val thumbnail: String
)

//data class Json4Kotlin_Base(
//
//    val response: NewsResponse
//)

data class NewsResponse(
    val results: List<NewsResults>
)

data class NewsResults(

    val type: String,
    val sectionName: String,
    val webPublicationDate: String,
    val webTitle: String,
    val webUrl: String,
    val fields: Fields
)
