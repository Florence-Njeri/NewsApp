package com.example.newsapp.ui.news

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.newsapp.R
import com.example.newsapp.adapter.HorizontalListAdapter
import com.example.newsapp.adapter.NewsAdapter
import com.example.newsapp.adapter.NewsListener
import com.example.newsapp.data.Article
import com.example.newsapp.databinding.FragmentNewsBinding

class NewsFragment : Fragment() {

    private lateinit var viewModel: NewsViewModel
    private lateinit var binding: FragmentNewsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewModel =ViewModelProviders.of(this).get(NewsViewModel::class.java)

        binding =FragmentNewsBinding.inflate(inflater)
        binding.toolbar.title= "News"

        binding.newsViewModel=viewModel
        binding.lifecycleOwner=this
        var adapter = NewsAdapter(NewsListener { news: Article->
                viewModel.onNewsItemClicked(news)

        })
        binding.worldNewsList.adapter = adapter

        var horizontalAdapter = HorizontalListAdapter(HorizontalListAdapter.OnClickListener{news->
            viewModel.onNewsItemClicked(news)

        })
        binding.horizontalNewsList.adapter=horizontalAdapter


        viewModel.fetchNews()
        viewModel.newsLiveData .observe(viewLifecycleOwner, androidx.lifecycle.Observer {

            //TODO - Your Update UI Logic
            it.let {
                if (it != null) {
                    /**                   Use submitList() to keep the list updated**/
                    adapter.submitList(it)
                } else {
                    Toast.makeText(activity, "Empty news list !!!", Toast.LENGTH_LONG).show()
                }
            }
        })
        viewModel.fetchHorizontalNews()
        viewModel.horizontalNewsLiveData.observe(viewLifecycleOwner, androidx.lifecycle.Observer {

            //TODO - Your Update UI Logic
            it.let {
                if (it != null) {
                    horizontalAdapter.submitList(it)
                } else {
                    Toast.makeText(activity, "Empty news list !!!", Toast.LENGTH_LONG).show()
                }
            }
        })

        viewModel.navigateToNewsDetails.observe(viewLifecycleOwner, Observer {news->
            news.let {
                if (null!=it) {
                    if (findNavController().currentDestination?.id == R.id.navigation_news) {
                        this.findNavController().navigate(
                            NewsFragmentDirections.actionNavigationNewsToNewsDetails(it)
                        )
                        viewModel.displayDetailsComplete()

                    }
                }
            }

        })
        return binding.root
    }
}

