package com.example.newsapp.network

import com.example.newsapp.data.NewsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 *
 */
interface NetworkClientApi {
    //    @GET("search?")
//    fun getNews(@Query("api_key") api_key: String): Call<NewsResults>
    @GET("search")
    fun getNewsAsync(
        @Query("api-key") apiKey: String,
        @Query("show-fields") fields: String,
        @Query("order-by") orderBy: String
    ): Call<NewsResponse>
}