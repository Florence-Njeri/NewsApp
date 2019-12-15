package com.example.newsapp.network
import com.example.newsapp.data.NewsResults
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 *
 */
interface NetworkClientApi {
    //    @GET("search?")
//    fun getNews(@Query("api_key") api_key: String): Call<NewsResults>
    @GET("v2/top-headlines")
    fun getNewsAsync(@Query("q") query: String): Deferred<Response<NewsResults>>
    @GET("v2/top-headlines")
    fun getHorizotalNewsAsync(@Query("q") query: String): Deferred<Response<NewsResults>>

}