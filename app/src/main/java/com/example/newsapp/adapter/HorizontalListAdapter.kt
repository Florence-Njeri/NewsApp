package com.example.newsapp.adapter

import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newsapp.database.Article
import com.example.newsapp.databinding.HorizontalNewsItemBinding
import java.text.SimpleDateFormat
import java.util.*


class HorizontalListAdapter(val onClickListener:OnClickListener) :ListAdapter<Article, HorizontalListAdapter.MyViewHolder>(DiffCallBack) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var layoutInflater = LayoutInflater.from(parent.context)
        val binding = HorizontalNewsItemBinding.inflate(layoutInflater,parent,false)
        return MyViewHolder(binding)
    }


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        //Bind item at the given position to the recycler view
        val news: Article = getItem(position)
        holder.itemView.setOnClickListener {
            onClickListener.onClick(news)
        }
        holder.bind(news,onClickListener)

    }


    class MyViewHolder(private var binding: HorizontalNewsItemBinding) : RecyclerView.ViewHolder(binding.root) {

        @RequiresApi(Build.VERSION_CODES.O)
        fun bind(news: Article,clickListener: OnClickListener) {
            binding.newsItem=news
            binding.clickListener=clickListener

            val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault())
            val date =
                dateFormat.parse(news.publishedAt)//You will get date object relative to server/client timezone wherever it is parsed
            val formatter =
                SimpleDateFormat("yyyy-MM-dd") //If you need time just put specific format for time like 'HH:mm:ss'
            val dateStr = formatter.format(date)

            binding.newsTitle.text = news.title
            binding.publishedAt.text = dateStr

            //Convert image URI to URL
            Glide.with(itemView)  //2
                .load(news.urlToImage) //3
                .into(binding.newsImage) //4
        }

    }

    companion object DiffCallBack : DiffUtil.ItemCallback<Article>() {
        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem == newItem
        }
    }
    class OnClickListener(val clickListener: (newsProperty: Article) -> Unit) {
        fun onClick(newsProperty:Article) = clickListener(newsProperty)
    }
}