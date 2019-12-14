package com.example.newsapp.model

import com.example.newsapp.data.Article
import com.example.newsapp.network.NetworkClientApi

class NewsRepository(private val api: NetworkClientApi):BaseRepository() {
    /*
     * method to fetch news
     * */

    suspend fun fetchNews(): MutableList<Article>? {

        //safeApiCall is defined in BaseRepository.kt
        val movieResponse = safeApiCall(
            call = {api.getNewsAsync().await()},
            errorMessage = "Error Fetching Popular Movies"
        )

        return movieResponse?.articles?.toMutableList()
//        val data = MutableLiveData<NewsResults>()
//        NetworkClient.theGuardianApi.getNewsAsync().enqueue(object : Callback<List<NewsResults>> {
//            override fun onFailure(call: Call<List<NewsResults>>, t: Throwable) {
//                println(t.message)
//                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//            }
//
//            override fun onResponse(call: Call<List<NewsResults>>, response: Response<List<NewsResults>>) {
//                println("Sucess : ${response.body()?.size}")
////                data.value = response.body().size
////                if (response != null && response.!= null) {
////                    callback.onSuccess(moviesResponse.getMovies());
////                } else {
////                    callback.onError();
////                }
//            }
//        })
//
//        return data
    }



}





