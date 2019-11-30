package com.example.newsapp.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
class Response {

    @SerializedName("response")
    @Expose
    var response: Response<*>? = null

}
class Fields {

    @SerializedName("thumbnail")
    @Expose
    var thumbnail: String? = null

}

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
    var orderBy: String ,
    @Expose
    @SerializedName("results")
    val results: MutableList<NewsResults>
)

class NewsResults {

    @SerializedName("id")
    @Expose
    var id: String? = null
    @SerializedName("type")
    @Expose
    var type: String? = null
    @SerializedName("sectionId")
    @Expose
    var sectionId: String? = null
    @SerializedName("sectionName")
    @Expose
    var sectionName: String? = null
    @SerializedName("webPublicationDate")
    @Expose
    var webPublicationDate: String? = null
    @SerializedName("webTitle")
    @Expose
    var webTitle: String? = null
    @SerializedName("webUrl")
    @Expose
    var webUrl: String? = null
    @SerializedName("apiUrl")
    @Expose
    var apiUrl: String? = null
    @SerializedName("fields")
    @Expose
    var fields: Fields? = null
    @SerializedName("isHosted")
    @Expose
    var isHosted: Boolean? = null
    @SerializedName("pillarId")
    @Expose
    var pillarId: String? = null
    @SerializedName("pillarName")
    @Expose
    var pillarName: String? = null

}
