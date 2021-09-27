package com.raj.androidfeatures.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.raj.androidfeatures.R
import com.raj.androidfeatures.adapter.NewsAdapter
import com.raj.androidfeatures.databinding.FragmentNewsListBinding

class NewListFragment : Fragment(R.layout.fragment_news_list) {
    private lateinit var _binding: FragmentNewsListBinding
    private lateinit var newsAdapter: NewsAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentNewsListBinding.bind(view)
        _binding.apply {
            recyclerView.apply {
                layoutManager = LinearLayoutManager(requireContext())
                newsAdapter = NewsAdapter()
                adapter = newsAdapter
                setHasFixedSize(true)
            }
        }
    }
}