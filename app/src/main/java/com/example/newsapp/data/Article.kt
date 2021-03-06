package com.example.newsapp.data
import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Article(
    val author: String?=null,
    val publishedAt: String?=null,
    val title: String?=null,
    val url: String?=null,
    val urlToImage: String?=null,
    val description:String?=null

):Parcelable
