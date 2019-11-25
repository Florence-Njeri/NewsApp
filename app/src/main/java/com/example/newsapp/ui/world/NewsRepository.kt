package com.example.newsapp.ui.world

import com.example.newsapp.data.News
import com.example.newsapp.network.WorldNewsApi

class NewsRepository(private val api : WorldNewsApi): BaseRepository() {
    suspend fun getNews() : MutableList<News>?{

        //safeApiCall is defined in BaseRepository.kt (https://gist.github.com/navi25/67176730f5595b3f1fb5095062a92f15)
        val newsResponse = safeApiCall(
            call = {api.getNews().await()},
            errorMessage = "Error Fetching Popular Movies"
        )

        return newsResponse?.results?.toMutableList();

    }
}