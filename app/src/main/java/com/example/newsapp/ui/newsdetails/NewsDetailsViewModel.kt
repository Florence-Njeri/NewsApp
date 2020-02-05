package com.example.newsapp.ui.newsdetails

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.newsapp.data.Article

class NewsDetailsViewModel(
    news: Article,
    application: Application
) : ViewModel() {

    // TODO: Implement the ViewModel
    private var _selectedItem = MutableLiveData<Article>()
    val selectedItem: LiveData<Article>
        get() = _selectedItem

    init {
        _selectedItem.value = news
        Log.i("SelectedItem", _selectedItem.value.toString())
    }


}
