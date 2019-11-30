package com.example.newsapp.ui.world

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
    private val _list = MutableLiveData<List<NewsResults>>().apply {

        }
    val list: LiveData<List<NewsResults>> = _list

    //Fetch data
    private val parentJob = Job()

    private val coroutineContext: CoroutineContext
        get() = parentJob + Dispatchers.Default

    private val scope = CoroutineScope(coroutineContext)

    private val newsRepository : NewsRepository= NewsRepository(NetworkClient.theGuardianApi)


    var newsListLiveData = MutableLiveData<NewsResponse>()

    fun fetchNews(){
        scope.launch {
          newsListLiveData= newsRepository.fetchNews()
//            popularMoviesLiveData.postValue(newsListLiveData)
        }
    }


    fun cancelAllRequests() = coroutineContext.cancel()

}
