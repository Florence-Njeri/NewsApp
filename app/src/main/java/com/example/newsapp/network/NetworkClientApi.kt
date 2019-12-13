package com.example.newsapp.network

import com.example.newsapp.data.NewsResponse
import com.example.newsapp.data.NewsResults
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

/**
 *
 */
interface NetworkClientApi {
    //    @GET("search?")
//    fun getNews(@Query("api_key") api_key: String): Call<NewsResults>
    @GET("search")
    fun getNewsAsync(): Deferred<Response<NewsResponse>>
}