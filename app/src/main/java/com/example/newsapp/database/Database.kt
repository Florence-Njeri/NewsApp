package com.example.newsapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.Room.databaseBuilder
import androidx.room.RoomDatabase
import com.example.newsapp.data.Article
import com.example.newsapp.data.DatabaseArticle
import okhttp3.internal.Internal.instance

//We have onl one table so for entities we suppl
@Database(entities = [DatabaseArticle::class], version = 2, exportSchema = false)
abstract class NewsDatabase :RoomDatabase(){

    //Declare an abstract value of NewsDao
    abstract val newsDatabaseDao: NewsDatabaseDao

    //Declare a companion object
    companion object{
        //INSTANCE will keep reference to the database once we have one (our db is a singleton)
        private lateinit var INSTANCE: NewsDatabase

        fun getDatabase(context: Context): NewsDatabase {
            synchronized(NewsDatabase::class.java){
                //Cop the value of INSTANCE to a local variable

                if (!::INSTANCE.isInitialized){
                    //Create DB
                    INSTANCE= databaseBuilder(
                        context.applicationContext,
                        NewsDatabase::class.java,
                        "news"
                    ).fallbackToDestructiveMigration()
                        .build()
                }
                return INSTANCE
            }
        }
    }
}
//We have onl one table so for entities we suppl
@Database(entities = [DatabaseArticle::class], version = 2, exportSchema = false)
abstract class HorizontalNewsDatabase :RoomDatabase(){

    //Declare an abstract value of NewsDao
    abstract val horizontalNewsDatabaseDao: HorizontalNewsDatabaseDao

    //Declare a companion object
    companion object{
        //INSTANCE will keep reference to the database once we have one (our db is a singleton)
        private lateinit var INSTANCE: HorizontalNewsDatabase

        fun getHorizontalNewsDatabase(context: Context): HorizontalNewsDatabase {
            synchronized(NewsDatabase::class.java){
                //Cop the value of INSTANCE to a local variable

                if (!::INSTANCE.isInitialized){
                    //Create DB
                    INSTANCE= databaseBuilder(
                        context.applicationContext,
                        HorizontalNewsDatabase::class.java,
                        "horizontal_news"
                    ).fallbackToDestructiveMigration()
                        .build()
                }
                return INSTANCE
            }
        }
    }
}
