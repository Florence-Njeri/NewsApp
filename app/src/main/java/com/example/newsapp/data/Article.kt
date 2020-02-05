package com.example.newsapp.data


import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize



@Parcelize
@Entity(tableName = "news_article_table")
data class Article(
    @PrimaryKey(autoGenerate = true)
    val newsId:Long=0L,
    @ColumnInfo(name = "author")
    @Json(name = "author")
    val author: String?,
    @ColumnInfo(name = "published_at")
    @Json(name = "publishedAt")
    val publishedAt: String?,
    @ColumnInfo(name = "title")
    @Json(name = "title")
    val title: String?,
    @ColumnInfo(name = "url")
    @Json(name = "url")
    val url: String?,
    @ColumnInfo(name = "url_to_image")
    @Json(name = "urlToImage")
    val urlToImage: String?,
    @ColumnInfo(name = "description")
    @Json(name = "description")
    val description:String?

):Parcelable
