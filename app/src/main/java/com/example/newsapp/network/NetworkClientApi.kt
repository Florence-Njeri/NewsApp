package com.example.newsapp.network
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
    fun getNewsAsync(@Query("q") query: String): Deferred<NetworkArticleContainer>
    @GET("v2/top-headlines")
    fun getHorizontalNewsAsync(@Query("q") query: String): Deferred<NetworkArticleContainer>

}