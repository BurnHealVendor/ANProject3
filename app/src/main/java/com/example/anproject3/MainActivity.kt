package com.example.anproject3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.anproject3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        MusicApp.musicComponent.inject(this)
    }
}