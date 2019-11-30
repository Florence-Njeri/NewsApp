package com.example.newsapp.model

import android.util.Log
import com.example.newsapp.constants.AppConstants
import com.example.newsapp.data.News
import com.example.newsapp.network.NetworkClientApi

class OldNewsRepository(private val api: NetworkClientApi) : BaseRepository() {
//    suspend fun getNews(key:String): MutableList<News>? {
//
//        //safeApiCall is defined in BaseRepository.kt (https://gist.github.com/navi25/67176730f5595b3f1fb5095062a92f15)
//        val newsResponse = safeApiCall(
//            call = { api.getNewsAsync(AppConstants.theGuardianApiKey).await() },
//            errorMessage = "Error Fetching Popular Movies"
//        )
//        if (newsResponse == null) {
//            Log.d("Newsrepository","Empty list returned")
//        }
//        return newsResponse?.results
//
//    }
}