package com.example.newsapp

import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.example.newsapp.data.Article
import com.example.newsapp.database.DatabaseArticle
import com.example.newsapp.database.NewsDatabase
import com.example.newsapp.database.NewsDatabaseDao
import junit.framework.Assert.assertEquals
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class)
class NewsDatabaseTest {

    private lateinit var newsDao: NewsDatabaseDao
    private lateinit var db: NewsDatabase

    @Before
    fun createDb() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        // Using an in-memory database because the information stored here disappears when the
        // process is killed.
        db = Room.inMemoryDatabaseBuilder(context, NewsDatabase::class.java)
            // Allowing main thread queries, just for testing.
            .allowMainThreadQueries()
            .build()
        newsDao = db.newsDatabaseDao
    }
    @Test
    @Throws(Exception::class)
    fun insertAndGetNight() {
        val newsArticle =DatabaseArticle()
        newsDao.insertAll(arrayOf(newsArticle))
        val article = newsDao.getAllArticles()
        assertEquals(article.value, -1)
    }
    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }


}