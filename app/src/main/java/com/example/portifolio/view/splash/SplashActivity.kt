package com.example.portifolio.view.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowManager
import com.example.portifolio.R
import com.example.portifolio.databinding.ActivitySplashBinding
import com.example.portifolio.view.home.HomeActivity

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySplashBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        supportActionBar?.hide();

        Handler(Looper.getMainLooper()).postDelayed({
            Intent(this@SplashActivity, HomeActivity::class.java).also{
                startActivity(it)
            }
            finish()
        }, 3000)
    }
}