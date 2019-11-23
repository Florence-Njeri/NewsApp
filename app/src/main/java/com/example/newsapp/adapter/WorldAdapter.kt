package com.example.newsapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.R
import com.example.newsapp.data.World

class WorldAdapter : RecyclerView.Adapter<WorldAdapter.MyViewHolder>() {
    var worldList = listOf<World>()
        set(value) {
            field=value
            notifyDataSetChanged()
        }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.news_item, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount() = 6

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        //Bind item at the given position to the recycler view
        holder.bind()
    }


    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var sectionName: TextView = view.findViewById(R.id.sectionName)
        var webTitle: TextView = view.findViewById(R.id.webTitle)
        var description: TextView = view.findViewById(R.id.description)
        var date: TextView = view.findViewById(R.id.date)
        var newsImage: ImageView = view.findViewById(R.id.imageView)
        fun bind(/*World*/) {
            sectionName.text = "World"
            webTitle.text = "Robbie Williams: The Christmas Present review – perfect for regifting."
            description.text =
                "Robbie does his full Rat Pack tribute act on a bunch of seasonal standards, and throws in some bonkers Christmas bonus songs of his own."
            date.text = "22nd November, 2019"
            newsImage.setImageResource(R.drawable.born_a_crime)
        }

    }
}