package com.example.portifolio.view.home

import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.portifolio.R
import com.example.portifolio.viewmodel.MainViewModel
import com.example.portifolio.databinding.ActivityMainBinding
import com.example.portifolio.model.User
import com.google.android.material.navigation.NavigationView
import com.google.android.material.tabs.TabLayoutMediator

import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var binding : ActivityMainBinding
    private lateinit var userAdapter: UserAdapter
    private lateinit var postViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setupRecyclerView()
        setupViewModel()
    }

    private fun setupRecyclerView() {
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        userAdapter = UserAdapter()
        binding.recyclerView.adapter = userAdapter
//        setHasFixedSize(true)

    }

    private fun setupViewModel(){
        postViewModel = ViewModelProvider(this)[MainViewModel::class.java]
        postViewModel.getPost()
        postViewModel.response.observe(this, Observer { users : List<User>->
            updateList(users)
        })
    }

    private fun updateList(orders: List<User>){
        if (orders.isEmpty()) {
            binding.recyclerView.visibility = View.GONE
        } else {
            binding.recyclerView.visibility = View.VISIBLE
            userAdapter.updateList(orders)
        }
    }
}