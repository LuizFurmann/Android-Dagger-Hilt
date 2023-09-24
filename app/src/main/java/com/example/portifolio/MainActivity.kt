package com.example.portifolio

import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidflow.Models.MovieResponse
import com.example.portifolio.adapter.PostAdapter
import com.example.androidflow.viewmodel.MainViewModel
import com.example.portifolio.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var postAdapter: PostAdapter
    private lateinit var binding : ActivityMainBinding

    val tabssArray = arrayOf(
        "Hoje",
        "Semana"
    )

    private val postViewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupTabLayout()

        postViewModel.getPost()

    }



    private fun setupTabLayout() {
        val viewPager = binding.appBarMain.viewpager
        val tabLayout = binding.appBarMain.tabLayout

        val adapter = ViewPagerAdapter(supportFragmentManager, lifecycle)
        viewPager.adapter = adapter

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = tabssArray[position]
        }.attach()
    }
}