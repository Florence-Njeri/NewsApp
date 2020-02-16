package com.example.newsapp.ui.news

import android.app.Application
import androidx.lifecycle.*
import com.example.newsapp.data.Article
import com.example.newsapp.database.NewsDatabase.Companion.getDatabase
import com.example.newsapp.network.NetworkClient
import com.example.newsapp.network.asDomainModel
import com.example.newsapp.repository.NewsRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch


/**
 *
 * A ViewModel holds the data required to be displayed on your layout
 * designed to store and manage the UI-related data
 * The ViewModel survives configuration changes
 */

class NewsViewModel(application: Application) : AndroidViewModel(application)  {

    //Fetch data
    /**
     * This is the job for all coroutines started by this ViewModel.
     *
     * Cancelling this job will cancel all coroutines started by this ViewModel.
     */
    private val viewModelJob = SupervisorJob()

    /**
     * This is the main scope for all coroutines launched by MainViewModel.
     *
     * Since we pass viewModelJob, you can cancel all coroutines launched by uiScope by calling
     * viewModelJob.cancel()
     */
    private val viewModelScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    //LiveData for navigation
    private val _navigateToNewsDetails = MutableLiveData<Article>()
    val navigateToNewsDetails: LiveData<Article>
        get() = _navigateToNewsDetails

    /**
     * The data source this ViewModel will fetch results from.
     */

    private val database = getDatabase(application)
    private val newsRepository = NewsRepository(database)

    /**
     * Refresh data from the repository. Use a coroutine launch to run in a
     * background thread.
     */
    /**
     * init{} is called immediately when this ViewModel is created.
     */
    init {
        viewModelScope.launch {
            newsRepository.refreshNews()
           // newsRepository.refreshHorizontalNews()

        }
    }

    val news1 = newsRepository.news
    val horizontalNews=newsRepository.news


    /** Handle RecyclerViewClicks**/
    fun onNewsItemClicked(news:Article) {
        _navigateToNewsDetails.value = news

    }

    //To clear LiveData to prevent it from being triggered again when we return from the DetailsView
    fun displayDetailsComplete(){
        _navigateToNewsDetails.value = null

    }
    /**
     * Cancel all coroutines when the ViewModel is cleared
     */
    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
    /**
     * Factory for constructing NewsViewModel with parameter
     */
    class Factory(val app: Application) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(NewsViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return NewsViewModel(app) as T
            }
            throw IllegalArgumentException("Unable to construct viewmodel")
        }
    }

}
