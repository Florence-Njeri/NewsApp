package com.example.newsapp.repository

interface NewsDataSource {
     suspend fun refreshTasks()

}