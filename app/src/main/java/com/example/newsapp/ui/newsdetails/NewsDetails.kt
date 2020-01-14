package com.example.newsapp.ui.newsdetails

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide

import com.example.newsapp.R
import com.example.newsapp.databinding.NewsDetailsFragmentBinding
import kotlinx.android.synthetic.main.horizontal_news_item.view.*
import kotlinx.android.synthetic.main.movie_details_content.view.*
import kotlinx.android.synthetic.main.news_details_fragment.view.*
import kotlinx.android.synthetic.main.news_item.view.*

class NewsDetails : Fragment() {
    private lateinit var binding: NewsDetailsFragmentBinding
    companion object {
        fun newInstance() = NewsDetails()
    }

    private lateinit var viewModel: NewsDetailsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =NewsDetailsFragmentBinding.inflate(inflater)
        viewModel = ViewModelProviders.of(this).get(NewsDetailsViewModel::class.java)
        // TODO: Use the ViewModel

        var args= arguments?.let { NewsDetailsArgs.fromBundle(it) }
        binding.layout.title.text=args?.title
        binding.layout.authors.text=args?.author
        binding.layout.content.text=args?.content
        Glide.with(this)  //2
            .load(args?.newsUrl) //3
            .into(binding.newsImage) //4
        return binding.root
    }



}
