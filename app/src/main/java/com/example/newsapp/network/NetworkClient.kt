package com.example.newsapp.network

import com.example.newsapp.constants.AppConstants
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 *  Create a retrofit instance to make a network request to a REST API with Retrofit
 */

object NetworkClient {

    //Creating Auth Interceptor to add api_key query in front of all the requests.
    private val authInterceptor = Interceptor { chain ->
        val newUrl = chain.request().url()
            .newBuilder()
            .addQueryParameter("api_key", AppConstants.theGuardianApiKey )
            .addQueryParameter("show-fields","thumbnail")
            .build()

        val newRequest = chain.request()
            .newBuilder()
            .url(newUrl)
            .build()

        chain.proceed(newRequest)
    }

    //OkhttpClient for building http request url
    private val theGuardianClient = OkHttpClient().newBuilder()
        .addInterceptor(authInterceptor)
        .build()


    fun retrofit(): Retrofit = Retrofit.Builder()
        .client(theGuardianClient)
        .baseUrl(AppConstants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()


   val theGuardianApi:NetworkClientApi  = retrofit().create(NetworkClientApi::class.java)
}