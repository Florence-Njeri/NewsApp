package com.example.newsapp.data

import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

/**
 * New data class
 */
data class Fields(

    val thumbnail: String
)

//data class Json4Kotlin_Base(
//
//    val response: Response
//)

data class NewsResponse(
    val status: String,
    val userTier: String,
    val total: Int,
    val startIndex: Int,
    val pageSize: Int,
    val currentPage: Int,
    val pages: Int,
    val orderBy: String,
    val results: List<NewsResults>
)

data class NewsResults(

    val id: String,
    val type: String,
    val sectionId: String,
    val sectionName: String,
    val webPublicationDate: String,
    val webTitle: String,
    val webUrl: String,
    val apiUrl: String,
    val fields: Fields,
    val isHosted: Boolean,
    val pillarId: String,
    val pillarName: String
)
//
//class Response {
//
//    @SerializedName("response")
//    @Expose
//    var response: Response<*>? = null
//
//}
//// Data Model for the Response returned from the the guardian Api
//data class NewsResponse(
//    @Expose
//    @Json("status")
//    var status: String,
//    @Expose
//    @Json("userTier")
//    internal var userTier: String,
//    @Expose
//    @Json("total")
//    var total: Int,
//=    @SerializedName("startIndex")
//    var startIndex: Int,
//    @Expose
//    @SerializedName("pageSize")
//    var pageSize: Int,
//    @Expose
//    @SerializedName("currentPage")
//    var currentPage: Int,
//    @Expose
//    @SerializedName("pages")
//    var pages: Int,
//    @Expose
//    @SerializedName("orderBy")
//    var orderBy: String ,
//    @Expose
//    @SerializedName("results")
//    val results: MutableList<NewsResults>
//)
//
//class NewsResults {
//
//    @SerializedName("id")
//    @Expose
//    var id: String? = null
//    @SerializedName("type")
//    @Expose
//    var type: String? = null
//    @SerializedName("sectionId")
//    @Expose
//    var sectionId: String? = null
//    @SerializedName("sectionName")
//    @Expose
//    var sectionName: String? = null
//    @SerializedName("webPublicationDate")
//    @Expose
//    var webPublicationDate: String? = null
//    @SerializedName("webTitle")
//    @Expose
//    var webTitle: String? = null
//    @SerializedName("webUrl")
//    @Expose
//    var webUrl: String? = null
//    @SerializedName("apiUrl")
//    @Expose
//    var apiUrl: String? = null
//    @SerializedName("fields")
//    @Expose
//    var fields: Fields? = null
//    @SerializedName("isHosted")
//    @Expose
//    var isHosted: Boolean? = null
//    @SerializedName("pillarId")
//    @Expose
//    var pillarId: String? = null
//    @SerializedName("pillarName")
//    @Expose
//    var pillarName: String? = null
//
//}
