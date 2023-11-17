package com.example.newsapp

import android.app.SearchManager
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.widget.SearchView
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.newsapp.adapter.SectionPagerAdapter
import com.example.newsapp.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding as ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setSupportActionBar(binding.toolbar)
        setContentView(binding.root)

        setupViewPager()

    }

    private fun setupViewPager() {
        binding.vpNews.adapter = SectionPagerAdapter(this)

        val tablist = arrayOf(
            "Common",
            "About Al Quran",
            "Al Jazeera",
            "Warn For Muslim"
        )
        TabLayoutMediator(binding.tabs, binding.vpNews){ tab,position ->
            tab.text = tablist[position]
        }.attach()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        (menu?.findItem(R.id.option_search)?.actionView as SearchView).apply {
            setSearchableInfo(searchManager.getSearchableInfo(componentName))
        }
        return true
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}