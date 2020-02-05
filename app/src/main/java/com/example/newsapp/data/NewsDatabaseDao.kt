package com.example.newsapp.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NewsDatabaseDao {
    @Insert
    fun insert(article: Article)

    @Update
    fun update(article: Article)

    //Get a specific news article based on key
    @Query("SELECT * FROM news_article_table WHERE newsId = :key" )
    fun get(key:Long) :Article

    //Clear the DB by deleting all the rows without deleting the table
    @Query("DELETE FROM news_article_table " )
    fun clear()

    //Return a list of sorted entities
    @Query("SELECT * FROM news_article_table ORDER BY newsId DESC")
    fun getAllNewsArticles():LiveData<List<Article>>


}