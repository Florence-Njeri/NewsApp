package com.example.newsapp.model

import com.example.newsapp.data.Article
import com.example.newsapp.network.NetworkClientApi

class HorizontalNewsRepository(private val api: NetworkClientApi):BaseRepository() {
    /*
     * method to fetch news
     * */

    suspend fun fetchHorizontalNews(): MutableList<Article>? {

        //safeApiCall is defined in BaseRepository.kt
        val horizontalMovieResponse = safeApiCall(
            call = { api.getHorizontalNewsAsync("Apple").await() },
            errorMessage = "Error Fetching Popular Movies"
        )

        return horizontalMovieResponse?.articles?.toMutableList()
    }

}





