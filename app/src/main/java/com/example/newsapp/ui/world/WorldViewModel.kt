package com.example.newsapp.ui.world

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.newsapp.data.NewsResults
import com.example.newsapp.data.NewsResponse
import com.example.newsapp.model.NewsRepository
import com.example.newsapp.network.NetworkClient
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext


/**
 *
 * A ViewModel holds the data required to be displayed on your layout
 * designed to store and manage the UI-related data
 * The ViewModel survives configuration changes
 */

class WorldViewModel: ViewModel() {
// ow


    //Fetch data
    private val parentJob = Job()

    private val coroutineContext: CoroutineContext
        get() = parentJob + Dispatchers.Default

    private val scope = CoroutineScope(coroutineContext)

    private val newsRepository : NewsRepository= NewsRepository(NetworkClient.theGuardianApi)


    var newsListLiveData = MutableLiveData<NewsResponse>()

    fun fetchNews(){
        scope.launch {
            val newsListLiveData= newsRepository.fetchNews()
            Log.d("NewsList:iveData",newsListLiveData.toString())
            newsListLiveData.postValue(newsListLiveData.value)
        }
    }


    fun cancelAllRequests() = coroutineContext.cancel()

}
