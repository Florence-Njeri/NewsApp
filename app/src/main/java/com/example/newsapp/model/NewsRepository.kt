package com.example.newsapp.model

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.newsapp.constants.AppConstants
import com.example.newsapp.data.News
import com.example.newsapp.data.NewsResponse
import com.example.newsapp.network.NetworkClient
import com.example.newsapp.network.NetworkClientApi
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsRepository(private val api: NetworkClientApi) {
    /*
     * method to fetch news
     * */

    fun fetchNews(): MutableLiveData<NewsResponse> {
        val data = MutableLiveData<NewsResponse>()
        NetworkClient.theGuardianApi.getNewsAsync(AppConstants.theGuardianApiKey,"thumbnail","relevance").enqueue(object :
            Callback<NewsResponse> {
            override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onResponse(call: Call<NewsResponse>, response: Response<NewsResponse>) {
                data.value = response.body()
//                if (response != null && response.!= null) {
//                    callback.onSuccess(moviesResponse.getMovies());
//                } else {
//                    callback.onError();
//                }
                }
        })

        return data
    }

    private fun throwError(throwable: Throwable?) {
        Log.e("tag", throwable.toString())
    }

}

