package com.example.newsapp.ui.world

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.newsapp.data.News
import com.example.newsapp.network.WorldNews
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

/**
 *
 * A ViewModel holds the data required to be displayed on your layout
 * designed to store and manage the UI-related data
 * The ViewModel survives configuration changes
 */

class WorldViewModel : ViewModel() {
    private lateinit var newsList: MutableList<News>
    private val _list = MutableLiveData<List<News>>().apply {

        }
    val list: LiveData<List<News>> = _list

    //Fetch data
    private val parentJob = Job()

    private val coroutineContext: CoroutineContext
        get() = parentJob + Dispatchers.Default

    private val scope = CoroutineScope(coroutineContext)

    private val repository : NewsRepository =NewsRepository(WorldNews.theGuardianApi)


    val popularMoviesLiveData = MutableLiveData<MutableList<News>>()

    fun fetchNews(){
        scope.launch {
            newsList = repository.getNews()!!
            popularMoviesLiveData.postValue(newsList)
        }
    }


    fun cancelAllRequests() = coroutineContext.cancel()
}