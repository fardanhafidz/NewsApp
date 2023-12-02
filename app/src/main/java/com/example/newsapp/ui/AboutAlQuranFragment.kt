package com.example.newsapp.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsapp.NewsViewsModel
import com.example.newsapp.adapter.NewsAdapter
import com.example.newsapp.databinding.FragmentAboutAlQuranBinding


class AboutAlQuranFragment : Fragment() {
    private var _binding: FragmentAboutAlQuranBinding? = null
    private val binding get() = _binding as FragmentAboutAlQuranBinding

    private var _quranNewsViewModel: NewsViewsModel? = null
    private val quranNewsViewModel get() = _quranNewsViewModel as NewsViewsModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentAboutAlQuranBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.loadingView.root.visibility = View.VISIBLE
        _quranNewsViewModel = ViewModelProvider(this)[NewsViewsModel::class.java]
        quranNewsViewModel.aboutAlQuranNews()
        quranNewsViewModel.aboutAlQuranNews.observe(viewLifecycleOwner) {
            val mAdapter = NewsAdapter()
            mAdapter.setData(it.articles)
            Log.i("AboutAlQuranFragment", "onViewCreated: ${it.articles}")
            binding.rvAlquraan.apply {
                adapter = mAdapter
                layoutManager = LinearLayoutManager(view.context)
            }
            binding.loadingView.root.visibility = View.GONE
        }
    }

}