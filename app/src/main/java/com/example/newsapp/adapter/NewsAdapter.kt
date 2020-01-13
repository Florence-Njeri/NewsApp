package com.example.newsapp.adapter

import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newsapp.data.Article
import com.example.newsapp.databinding.NewsItemBinding
import kotlinx.android.synthetic.main.news_item.view.*
import java.text.SimpleDateFormat
import java.util.*


class NewsAdapter(val clickListener:NewsListener) : ListAdapter<Article, NewsAdapter.MyViewHolder>(DiffCallback){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var layoutInflater = LayoutInflater.from(parent.context)
        return MyViewHolder(NewsItemBinding.inflate(layoutInflater))
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        //Bind item at the given position to the recycler view
        val news: Article = getItem(position)
        holder.bind(news,clickListener)
    }


    class MyViewHolder(private var binding: NewsItemBinding) : RecyclerView.ViewHolder(binding.root) {

        @RequiresApi(Build.VERSION_CODES.O)
        fun bind(
            news: Article,
            clickListener: NewsListener
        ) {

            binding.newsItem=news
            binding.clickListener=clickListener
            val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault())
            val date =
                dateFormat.parse(news.publishedAt)//You will get date object relative to server/client timezone wherever it is parsed
            val formatter =
                SimpleDateFormat("yyyy-MM-dd") //If you need time just put specific format for time like 'HH:mm:ss'
            val dateStr = formatter.format(date)


            binding.author.text = news.author
            binding.newsTitle.text = news.title
            binding.publishedAt.text = dateStr

            //Convert image URI to URL
            Glide.with(itemView)  //2
                .load(news.urlToImage) //3
//                .centerCrop() //4
//                .placeholder(R.drawable.ic_image_place_holder) //5
//                .error(R.drawable.ic_broken_image) //6
//                .fallback(R.drawable.ic_no_image) //7
                .into(itemView.imageView) //8            newsImage.setImageResource(R.drawable.born_a_crime)
            binding.executePendingBindings()
        }

    }
    companion object DiffCallback : DiffUtil.ItemCallback<Article>() {
        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem.title == newItem.title
        }
    }
}
class NewsListener(val clickListener:(title:String)-> Unit){
    fun onClick(news:Article)=clickListener(news.title.toString())
}