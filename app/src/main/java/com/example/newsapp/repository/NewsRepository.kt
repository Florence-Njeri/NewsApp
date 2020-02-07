package com.example.newsapp.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.newsapp.data.Article
import com.example.newsapp.database.NewsDatabase
import com.example.newsapp.database.asDomainModel
import com.example.newsapp.network.NetworkClient
import com.example.newsapp.network.asDatabaseModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

// Pass in a NewsDatabase object as the class's constructor parameter to access the Dao methods.
class NewsRepository (private val newsDatabase: NewsDatabase) {

    // use Transformations.map to convert the list of database objects to a list of domain objects.
    val news: LiveData<List<Article>> =Transformations.map(newsDatabase.newsDatabaseDao.getAllArticles()){
        it.asDomainModel()
    }

    /**
     * Refresh the news stored in the offline cache.
     *
     * This function uses the IO dispatcher to ensure the database insert database operation
     * happens on the IO dispatcher. By switching to the IO dispatcher using `withContext` this
     * function is now safe to call from any thread including the Main thread.
     *
     */
    suspend fun refreshNews() {
        withContext(Dispatchers.IO) {
            val newslist=NetworkClient.theGuardianApi.getNewsAsync("tech").await()
            val horizontalNewslist =NetworkClient.theGuardianApi.getHorizontalNewsAsync("tech").await()

        newsDatabase.newsDatabaseDao.insertAll(newslist.asDatabaseModel())
            newsDatabase.newsDatabaseDao.insertAll(horizontalNewslist.asDatabaseModel())
        }
    }

}