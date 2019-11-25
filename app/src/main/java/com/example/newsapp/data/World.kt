package com.example.newsapp.data

import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

data class World(
    var sectionName: String,
    var date: String,
    var webTitle: String,
    var description: String,
    var image: Int
)

// Data Model for the Response returned from the the guardian Api
data class NewsResponse(
    val results: List<World>
)

//A retrofit Network Interface for the Api
interface TmdbApi {
    @GET("movie/popular")
    fun getPopularMovie(): Deferred<Response<NewsResponse>>
}