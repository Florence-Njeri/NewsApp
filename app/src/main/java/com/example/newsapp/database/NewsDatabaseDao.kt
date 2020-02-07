package com.example.newsapp.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.newsapp.data.Article

/**
 * Add a wa to save data @param insert
 * and a wa to fetch data @property getAllNewsArticles
 */
@Dao
interface NewsDatabaseDao {

    //Return a list of all the articles from the db
    @Query("SELECT * FROM news_article_table ")
    fun getAllArticles():LiveData<List<DatabaseArticle>>

    /**Update DB and insert data fetched from network into it
    * method to insert a list of articles fetched from the network into the database
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll( videos: List<DatabaseArticle>)

}