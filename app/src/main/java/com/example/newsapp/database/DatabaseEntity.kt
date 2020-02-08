package com.example.newsapp.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.newsapp.data.Article
import com.squareup.moshi.Json
import org.jetbrains.annotations.NotNull

@Entity(tableName = "news_article_table")
data class DatabaseArticle(
    @ColumnInfo(name = "author")
    @Json(name = "author")
    val author: String?=null,
    @ColumnInfo(name = "published_at")
    @Json(name = "publishedAt")
    val publishedAt: String?=null,
    @ColumnInfo(name = "title")
    @Json(name = "title")
    val title: String?=null,
    @PrimaryKey
    @Json(name = "url")
    val url: String,
    @ColumnInfo(name = "url_to_image")
    @Json(name = "urlToImage")
    val urlToImage: String?=null,
    @ColumnInfo(name = "description")
    @Json(name = "description")
    val description:String?=null

)

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