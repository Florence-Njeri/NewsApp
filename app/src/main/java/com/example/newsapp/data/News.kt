package com.example.newsapp.data

import androidx.lifecycle.MutableLiveData
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

data class News(
    @Expose
    @SerializedName("sectionName")
    var sectionName: String = "",
    @Expose
    @SerializedName("webPublicationDate")
    internal var date: String = "",
    @Expose
    @SerializedName("title")
    var title: String = "",
    @Expose
    @SerializedName("thumbnail")
    var thumbnail: Int = 0
)

// Data Model for the Response returned from the the guardian Api
data class NewsResponse(
    @Expose
    @SerializedName("status")
    var status: String,
    @Expose
    @SerializedName("userTier")
    internal var userTier: String,
    @Expose
    @SerializedName("total")
    var total: Int,
    @Expose
    @SerializedName("startIndex")
    var startIndex: Int,
    @Expose
    @SerializedName("pageSize")
    var pageSize: Int,
    @Expose
    @SerializedName("currentPage")
    var currentPage: Int,
    @Expose
    @SerializedName("pages")
    var pages: Int,
    @Expose
    @SerializedName("orderBy")
    var orderBy: String = "",
    @Expose
    @SerializedName("results")
    val results: MutableList<News>
)

//A retrofit Network Interface for the Api
interface TheGuardianApi {
    @GET("search")
    fun getNews(): Deferred<Response<NewsResponse>>
}