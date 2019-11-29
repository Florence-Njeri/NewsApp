package com.example.newsapp.ui.world

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.newsapp.constants.AppConstants
import com.example.newsapp.data.News
import com.example.newsapp.network.NetworkClientApi
import retrofit2.Call

class NewsRepository(private val api : NetworkClientApi): BaseRepository() {
    suspend fun getNews() : MutableLiveData<List<News>> {

        //safeApiCall is defined in BaseRepository.kt (https://gist.github.com/navi25/67176730f5595b3f1fb5095062a92f15)
        val newsResponse = safeApiCall(
            call = {api.getNews(AppConstants.theGuardianApiKey).await()},
            errorMessage = "Error Fetching Popular Movies"
        )

        return newsResponse?.results!!

    }
}