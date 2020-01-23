package com.example.newsapp.ui.newsdetails

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import com.bumptech.glide.Glide
import com.example.newsapp.databinding.NewsDetailsFragmentBinding

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
        val application= requireNotNull(activity).application
        binding = NewsDetailsFragmentBinding.inflate(inflater)
        binding.lifecycleOwner = this

        binding.toolbar.apply {
            setNavigationOnClickListener { findNavController().navigateUp() }
            setTitle("News Details")
        }

        /**
         * Get the selected properties from the arguments bundle
         */
        var newsProperty = arguments?.let { NewsDetailsArgs.fromBundle(arguments!!).selectedProperty }
        /**
         * Get the ViewModelFactory
         */
        val viewModelFactory = newsProperty?.let { DetailsViewModelFactory(it,application) }
        binding.viewModel = ViewModelProviders.of(this, viewModelFactory).get(NewsDetailsViewModel::class.java)

        binding.layout.title.text = newsProperty?.title.toString()
        binding.layout.authors.text = newsProperty?.author.toString()
        binding.layout.description.text = newsProperty?.description.toString()
        Log.i("NewsPropertyTitle",newsProperty?.title.toString())
        Glide.with(this)  //2
            .load(newsProperty?.urlToImage) //3
            .into(binding.newsImage) //4

        //Read more
        binding.layout.readMore.setOnClickListener {
            val uri = Uri.parse(newsProperty?.url) // missing 'http://' will cause a crash
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }
        return binding.root
    }


}
