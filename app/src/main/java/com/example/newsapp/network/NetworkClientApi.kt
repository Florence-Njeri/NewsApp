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
    @GET("search?")
    fun getNews(@Query("api_key,show-fields") api_key: String) : Deferred<Response<NewsResponse>>
//    @GET("movie/{id}")
//    fun getNewsById(@Path("id") id:Int): Deferred<Response<News>>
}