package com.example.newsapp.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

//We have onl one table so for entities we suppl
@Database(entities = [Article::class], version = 1, exportSchema = false)
abstract class NewsDatabase :RoomDatabase(){

    //Declare an abstract value of NewsDao
    abstract val newsDatabaseDao:NewsDatabaseDao

    //Declare a companion object
    companion object{
        //INSTANCE will keep reference to the database once we have one
        private var INSTANCE:NewsDatabase? = null

        fun getInstance(context: Context): NewsDatabase{
            synchronized(this){
                //Cop the value of INSTANCE to a local variable
                var instance= INSTANCE

                if (instance==null){
                    //Create DB
                    instance= Room.databaseBuilder(
                        context.applicationContext,
                        NewsDatabase::class.java,
                        "news_fetched_database"
                    )
                        //For migration i.e. if we change the migration schema b changine no. of colims we need to convert rows in old schema to rows in the new shema
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE=instance

                }
                return instance
            }
        }
    }
}