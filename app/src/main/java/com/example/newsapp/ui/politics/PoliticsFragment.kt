package com.example.newsapp.ui.politics

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.newsapp.R

class PoliticsFragment : Fragment() {

    private lateinit var politicsViewModel: PoliticsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        politicsViewModel =
            ViewModelProviders.of(this).get(PoliticsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_politics, container, false)
        val textView: TextView = root.findViewById(R.id.text_notifications)
        politicsViewModel.text.observe(this, Observer {
            textView.text = it
        })
        return root
    }
}