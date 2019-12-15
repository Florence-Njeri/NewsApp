package com.example.newsapp.ui.world

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.newsapp.data.Article
import com.example.newsapp.model.HorizontalNewsRepository
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
    val _news = MutableLiveData<Article>()

    val news:LiveData<Article>
        get() =_news
    //Fetch data
    private val parentJob = Job()

    private val coroutineContext: CoroutineContext
        get() = parentJob + Dispatchers.Default

    private val scope = CoroutineScope(coroutineContext)

    private val repository : NewsRepository= NewsRepository(NetworkClient.theGuardianApi)
    private val horizontalNewsRepository : HorizontalNewsRepository= HorizontalNewsRepository(NetworkClient.theGuardianApi)
    val newsLiveData = MutableLiveData<MutableList<Article>>()
    val horizontalNewsLiveData = MutableLiveData<MutableList<Article>>()


    fun fetchNews(){
        //Done on background thread
        scope.launch {
            val news= repository.fetchNews()
            Log.d("NewsList:iveData",news.toString())
            if (news != null) {
                if(news.size>0){
                    newsLiveData.postValue(news)

                }
            }
            val horizontalListNews=horizontalNewsRepository.fetchHorizontalNews()
            if (horizontalListNews != null) {
                if(horizontalListNews.size>0){
                    horizontalNewsLiveData.postValue(news)

                }
            }

        }
    }

//To cancel the job request when the view model is destroyed
    fun cancelAllRequests() = coroutineContext.cancel()

}
