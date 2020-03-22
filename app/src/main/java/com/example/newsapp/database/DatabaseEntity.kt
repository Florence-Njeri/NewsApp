package com.example.newsapp.database

import com.example.newsapp.data.Article
import com.example.newsapp.data.DatabaseArticle


//Add an extension function which converts from database objects to domain objects.

fun List<DatabaseArticle>.asDomainModel(): List<Article> {
    return map {
        Article(
            url = it.url,
            title = it.title,
            description = it.description,
            author = it.author,
            publishedAt = it.publishedAt,
            urlToImage = it.urlToImage
            )
    }
}