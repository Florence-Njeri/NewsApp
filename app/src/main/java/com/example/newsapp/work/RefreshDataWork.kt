package com.example.newsapp.work

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.newsapp.database.NewsDatabase.Companion.getDatabase
import com.example.newsapp.repository.NewsRepository
import retrofit2.HttpException

/**
 * to pre-fetch data when the app is in the background.
 * Using WorkManager
 */
class RefreshDataWorker(appContext: Context, params: WorkerParameters) :
    CoroutineWorker(appContext, params) {
companion object{
    const val WORK_NAME = "RefreshDataWorker"

}

    override suspend fun doWork(): Payload {
        val database = getDatabase(applicationContext)
        val repository = NewsRepository(database)
        return try {
            repository.refreshHorizontalNews()
            repository.refreshNews()

            Payload(Result.SUCCESS)
        } catch (exception: HttpException) {
            Payload(Result.RETRY) //If network request fails
        }

    }

}