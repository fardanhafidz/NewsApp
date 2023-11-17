package com.example.newsapp.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.newsapp.ui.AboutAlQuranFragment
import com.example.newsapp.ui.CommonFragment
import com.example.newsapp.ui.WarningFragment
import com.example.newsapp.ui.aljazeera

class SectionPagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {

    override fun getItemCount() = 4

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> CommonFragment()
            1 -> AboutAlQuranFragment()
            2 -> aljazeera()
            3 -> WarningFragment()
            else -> aljazeera()
        }
    }
}