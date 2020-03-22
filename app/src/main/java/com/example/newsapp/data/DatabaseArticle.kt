package com.example.newsapp.data
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json

@Entity(tableName = "news_article_table")
data class DatabaseArticle constructor(
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
    @ColumnInfo(name = "url")
    @Json(name = "url")
    val url: String,
    @ColumnInfo(name = "url_to_image")
    @Json(name = "urlToImage")
    val urlToImage: String?=null,
    @ColumnInfo(name = "description")
    @Json(name = "description")
    val description:String?=null

)
