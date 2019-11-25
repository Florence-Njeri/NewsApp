package com.example.newsapp.ui.world

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.newsapp.data.News

class WorldViewModel : ViewModel() {

    private val _list = MutableLiveData<List<News>>().apply {
//        value = "This is dashboard Fragment"
    }
    val list: LiveData<List<News>> = _list
}