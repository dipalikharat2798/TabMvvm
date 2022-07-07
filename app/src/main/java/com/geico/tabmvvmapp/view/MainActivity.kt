package com.geico.tabmvvmapp.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.databinding.DataBindingUtil
import com.geico.tabmvvmapp.R
import com.geico.tabmvvmapp.databinding.ActivityMainBinding
import dagger.hilt.EntryPoint


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Displaying edge-to-edge
        WindowCompat.setDecorFitsSystemWindows(window, false)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

    }
}