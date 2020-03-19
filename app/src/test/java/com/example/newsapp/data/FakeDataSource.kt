package com.example.newsapp.data

import com.example.newsapp.repository.NewsDataSource
import org.apache.tools.ant.Task

class FakeDataSource: NewsDataSource {
    override suspend fun refreshTasks() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}