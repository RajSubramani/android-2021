package com.raj.androidfeatures.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.raj.androidfeatures.R
import com.raj.androidfeatures.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var _binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(_binding.root)
        supportFragmentManager.beginTransaction()
            .add(R.id.fragmentContainer, NewListFragment(), "newsList").commit()

    }
}