package com.example.portifolio.view.home

import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.portifolio.R
import com.example.portifolio.viewmodel.MainViewModel
import com.example.portifolio.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView
import com.google.android.material.tabs.TabLayoutMediator

import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var binding : ActivityMainBinding
    lateinit var toggle: ActionBarDrawerToggle

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
        setupDrawer()

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

    private fun setupDrawer(){
        val draweLayout : DrawerLayout = binding.drawerLayout
        val navView : NavigationView = binding.navView

        toggle = ActionBarDrawerToggle(this,draweLayout, R.string.nav_open, R.string.nav_open)
        draweLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navView.setNavigationItemSelectedListener {

            when(it.itemId){
                R.id.nav_alunos -> Toast.makeText(this, "teste", Toast.LENGTH_SHORT).show()
            }
            true
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if(toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}