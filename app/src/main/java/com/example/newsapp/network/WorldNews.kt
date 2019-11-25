package com.example.newsapp.network

import com.example.newsapp.constants.AppConstants
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class WorldNews {

    //Creating Auth Interceptor to add api_key query in front of all the requests.
    private val authInterceptor = Interceptor { chain ->
        val newUrl = chain.request().url()
            .newBuilder()
            .addQueryParameter("api_key", AppConstants.theGuardianApiKey )
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
        .baseUrl("https://content.guardianapis.com/search?")
        .addConverterFactory(MoshiConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()


    val theGuardianApi:WorldNewsService  = retrofit().create(WorldNewsService::class.java)
}