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
        binding.description.text=args?.description
        Glide.with(this)  //2
            .load(args?.newsUrl) //3
//                .centerCrop() //4
//                .placeholder(R.drawable.ic_image_place_holder) //5
//                .error(R.drawable.ic_broken_image) //6
//                .fallback(R.drawable.ic_no_image) //7
            .into(binding.newsImage) //8
        return binding.root
    }



}
