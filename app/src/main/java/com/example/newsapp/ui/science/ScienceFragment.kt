package com.example.newsapp.ui.science

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.newsapp.R

class ScienceFragment : Fragment() {

    private lateinit var scienceViewModel: ScienceViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        scienceViewModel =
            ViewModelProviders.of(this).get(ScienceViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_science, container, false)
        val textView: TextView = root.findViewById(R.id.text_science)
        scienceViewModel.text.observe(this, Observer {
            textView.text = it
        })
        return root
    }
}