package com.example.newsapp.network

import com.example.newsapp.constants.AppConstants
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 *  Create a retrofit instance to make a network request to a REST API with Retrofit
 */

object NetworkClient {

    //Creating Auth Interceptor to add api_key query in front of all the requests.
    private val authInterceptor = Interceptor { chain ->
        val newUrl = chain.request().url()
            .newBuilder()
//            .addQueryParameter("api_key", AppConstants.theGuardianApiKey )
//            .addQueryParameter("show-fields","thumbnail")
//            .addQueryParameter("q","world")
//            .addQueryParameter("order-by","relevance")
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

    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()


    fun retrofit(): Retrofit = Retrofit.Builder()
        .baseUrl(AppConstants.BASE_URL)
        .client(theGuardianClient)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()


   val theGuardianApi:NetworkClientApi  = retrofit().create(NetworkClientApi::class.java)
}