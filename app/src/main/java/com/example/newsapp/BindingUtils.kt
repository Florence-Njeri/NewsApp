package com.example.newsapp

import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.newsapp.data.Article
import java.text.SimpleDateFormat
import java.util.*


class BindingUtils {
    @BindingAdapter("author")
    fun TextView.setAuthorFormatted(item: Article) {
        text = item.author
    }
    @BindingAdapter("title")
    fun TextView.setNewsTitleFormatted(item: Article) {
        text = item.title
    }
    @BindingAdapter("publishedAt")
    fun TextView.setNewsPublishedAtFormatted(item: Article) {

        val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault())
        val date =
            dateFormat.parse(item.publishedAt)//You will get date object relative to server/client timezone wherever it is parsed
        val formatter =
            SimpleDateFormat("yyyy-MM-dd") //If you need time just put specific format for time like 'HH:mm:ss'
        val dateStr = formatter.format(date)

        text = dateStr
    }

}