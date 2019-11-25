package com.example.newsapp.network

import com.example.newsapp.data.News
import com.example.newsapp.data.NewsResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

//add all the required API calls
interface WorldNewsService {
    @GET("search")
    fun getNews() : Deferred<Response<NewsResponse>>
//    @GET("movie/{id}")
//    fun getNewsById(@Path("id") id:Int): Deferred<Response<News>>
}