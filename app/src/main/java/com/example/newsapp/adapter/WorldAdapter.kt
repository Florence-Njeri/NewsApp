package com.example.newsapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newsapp.R
import com.example.newsapp.data.Article
import kotlinx.android.synthetic.main.news_item.view.*

class WorldAdapter : RecyclerView.Adapter<WorldAdapter.MyViewHolder>() {
    var worldList = listOf<Article>()
        set(value) {
            field=value
            notifyDataSetChanged()
        }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.news_item, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount() = worldList.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        //Bind item at the given position to the recycler view
        val news: Article = worldList[position]
        holder.bind(news)
    }


    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var author: TextView = view.findViewById(R.id.author)
        var webTitle: TextView = view.findViewById(R.id.newsTitle)
        var description: TextView = view.findViewById(R.id.description)
        var date: TextView = view.findViewById(R.id.publishedAt)
        var newsImage: ImageView = view.findViewById(R.id.imageView)
        fun bind(news:Article) {
            author.text = "Florence Njeri"
            webTitle.text = news.title
            description.text = news.description
            date.text = news.publishedAt

            //Convert image URI to URL
            Glide.with(itemView)  //2
                .load(news.urlToImage) //3
//                .centerCrop() //4
//                .placeholder(R.drawable.ic_image_place_holder) //5
//                .error(R.drawable.ic_broken_image) //6
//                .fallback(R.drawable.ic_no_image) //7
                .into(itemView.imageView) //8            newsImage.setImageResource(R.drawable.born_a_crime)
        }

    }
}