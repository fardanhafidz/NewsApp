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
import com.example.newsapp.databinding.FragmentWarningBinding

class WarningFragment : Fragment() {

    private var _binding: FragmentWarningBinding? = null
    private val binding get() = _binding!!

    private var _warnMuslimViewModel: NewsViewsModel? = null
    private val warnMuslimViewModel get() = _warnMuslimViewModel as NewsViewsModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentWarningBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.loadingView.root.visibility = View.VISIBLE
        _warnMuslimViewModel = ViewModelProvider(this)[NewsViewsModel::class.java]
        warnMuslimViewModel.warningForMuslimNews()
        warnMuslimViewModel.warningForMuslimNews.observe(viewLifecycleOwner) {
            val mAdapter = NewsAdapter()
            mAdapter.setData(it.articles)
            Log.i("CommonFragment", "onViewCreated: ${it.articles}")
            binding.rvWarningNews.apply {
                adapter = mAdapter
                layoutManager = LinearLayoutManager(view.context)
            }
            binding.loadingView.root.visibility = View.GONE
        }
    }
}