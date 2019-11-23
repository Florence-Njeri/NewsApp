package com.example.newsapp.ui.world

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsapp.R
import com.example.newsapp.adapter.WorldAdapter
import com.example.newsapp.databinding.FragmentWorldBinding

class WorldFragment : Fragment() {

    private lateinit var worldViewModel: WorldViewModel
    private lateinit var binding: FragmentWorldBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        worldViewModel =
            ViewModelProviders.of(this).get(WorldViewModel::class.java)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_world, container, false)
        var adapter = WorldAdapter()
        binding.worldNewsList.adapter = adapter
//        binding.worldNewsList.layoutManager= LinearLayoutManager(activity, LinearLayoutManager.VERTICAL ,false)
        worldViewModel.list.observe(viewLifecycleOwner, Observer {
            it?.let{
                adapter.worldList= it
            }
        })


        return binding.root
    }
}