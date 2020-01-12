package com.example.newsapp.ui.news

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.newsapp.adapter.HorizontalListAdapter
import com.example.newsapp.adapter.WorldAdapter
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

        binding.newsViewModel=viewModel
        binding.lifecycleOwner=this
        var adapter = WorldAdapter()
        binding.worldNewsList.adapter = adapter
        //        binding.worldNewsList.layoutManager= LinearLayoutManager(activity, LinearLayoutManager.VERTICAL ,false)
        //Horizontal News List
        var horizontalAdapter = HorizontalListAdapter()
        binding.horizontalNewsList.adapter=horizontalAdapter


        viewModel.fetchNews()
        viewModel.newsLiveData .observe(viewLifecycleOwner, Observer {

            //TODO - Your Update UI Logic
            it.let{
                if (it != null) {
                    adapter.worldList= it
                }
                else{
                    Toast.makeText(activity,"Empty news list !!!",Toast.LENGTH_LONG).show()
                }
            }
        })
        viewModel.fetchHorizontalNews()
        viewModel.horizontalNewsLiveData.observe(viewLifecycleOwner, Observer {

            //TODO - Your Update UI Logic
            it.let{
                if (it != null) {
                    horizontalAdapter.horizontalNewsList= it
                }
                else{
                    Toast.makeText(activity,"Empty news list !!!",Toast.LENGTH_LONG).show()
                }
            }
        })

        return binding.root
    }
}
