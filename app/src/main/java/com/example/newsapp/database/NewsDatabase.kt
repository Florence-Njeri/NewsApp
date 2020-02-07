package com.example.newsapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.newsapp.data.Article
import okhttp3.internal.Internal.instance

//We have onl one table so for entities we suppl
@Database(entities = [DatabaseArticle::class], version = 1, exportSchema = false)
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
                    INSTANCE= Room.databaseBuilder(
                        context.applicationContext,
                        NewsDatabase::class.java,
                        "news_fetched_database"
                    )
                        //For migration i.e. if we change the migration schema b changine no. of colims we need to convert rows in old schema to rows in the new shema
                        .fallbackToDestructiveMigration()
                        .build()

                }
                return INSTANCE
            }
        }
    }
}