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
    var sectionName: String,
    @Expose
    @SerializedName("webPublicationDate")
    internal var date: String,
    @Expose
    @SerializedName("title")
    var title: String,
    @Expose
    @SerializedName("thumbnail")
    var thumbnail: Int
)

// Data Model for the Response returned from the the guardian Api
data class NewsResponse(
    val results: MutableLiveData<List<News>>
)

//A retrofit Network Interface for the Api
interface TheGuardianApi {
    @GET("movie/popular")
    fun getNews(): Deferred<Response<NewsResponse>>
}