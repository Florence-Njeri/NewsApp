package com.example.newsapp.adapter

import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newsapp.R
import com.example.newsapp.data.Article
import kotlinx.android.synthetic.main.news_item.view.*
import java.text.SimpleDateFormat
import java.util.*


class HorizontalListAdapter : RecyclerView.Adapter<HorizontalListAdapter.MyViewHolder>() {
    var horizontalNewsList = listOf<Article>()
        set(value) {
            field=value
            notifyDataSetChanged()
        }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.horizontal_news_item, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount() = horizontalNewsList.size

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        //Bind item at the given position to the recycler view
        val news: Article = horizontalNewsList[position]
        holder.bind(news)
    }


    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var webTitle: TextView = view.findViewById(R.id.newsTitle)
        var dateTv: TextView = view.findViewById(R.id.publishedAt)
        var newsImage: ImageView = view.findViewById(R.id.newsImage)
        @RequiresApi(Build.VERSION_CODES.O)
        fun bind(news:Article) {

            val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault())
            val date = dateFormat.parse(news.publishedAt)//You will get date object relative to server/client timezone wherever it is parsed
            val formatter = SimpleDateFormat("yyyy-MM-dd") //If you need time just put specific format for time like 'HH:mm:ss'
            val dateStr = formatter.format(date)

            webTitle.text = news.title
            dateTv.text=dateStr

            //Convert image URI to URL
            Glide.with(itemView)  //2
                .load(news.urlToImage) //3
//                .centerCrop() //4
//                .placeholder(R.drawable.ic_image_place_holder) //5
//                .error(R.drawable.ic_broken_image) //6
//                .fallback(R.drawable.ic_no_image) //7
                .into(newsImage) //8            newsImage.setImageResource(R.drawable.born_a_crime)
        }

    }
}