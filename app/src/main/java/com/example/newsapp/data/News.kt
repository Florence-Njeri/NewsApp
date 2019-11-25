package com.example.newsapp.data

import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

data class News(
    var sectionName: String,
    var date: String,
    var webTitle: String,
    var description: String,
    var image: Int
)

// Data Model for the Response returned from the the guardian Api
data class NewsResponse(
    val results: List<News>
)

//A retrofit Network Interface for the Api
interface TheGuardianApi {
    @GET("movie/popular")
    fun getNews(): Deferred<Response<NewsResponse>>
}