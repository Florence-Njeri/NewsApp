package com.example.newsapp.network

import com.example.newsapp.data.News
import com.example.newsapp.data.NewsResponse
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 *
 */
interface NetworkClientApi {
    //    @GET("search?")
//    fun getNews(@Query("api_key") api_key: String): Call<News>
    @GET("search")
    fun getNewsAsync(
        @Query("api_key") apiKey: String,
        @Query("show-fields") fields: String,
        @Query("order-by") orderBy: String
    ): Call<NewsResponse>
}