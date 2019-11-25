package com.example.newsapp.data

import com.example.newsapp.network.WorldNewsService

class WorldNews {
    var retrofit = Retrofit.Builder()
        .baseUrl("https://api.github.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
//    We will parse this JSON response and get the required values and store them in our data class.
    var service = retrofit.create(WorldNewsService::class.java)
}