package com.example.newsapp.ui.newsdetails

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.newsapp.data.Article

/**
 * A factory method to instantiate the ViewModel.
 */
class DetailsViewModelFactory(private val newsProperty: Article,
                              private val application: Application
) :ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NewsDetailsViewModel::class.java)) {
            return NewsDetailsViewModel(newsProperty, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }    }

