package com.example.lovecat4

import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity

import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.example.lovecat4.api.RetrofitInstance
import com.example.lovecat4.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
           binding.catbutton.setOnClickListener {
               lifecycleScope.launch {
                  var result= RetrofitInstance.service.getImages(num = 4)
                   Glide.with(this@MainActivity).load(result[0].url).into(binding.ivAlbum1)
                   Glide.with(this@MainActivity).load(result[1].url).into(binding.ivAlbum2)
                   Glide.with(this@MainActivity).load(result[2].url).into(binding.ivAlbum3)
                   Glide.with(this@MainActivity).load(result[3].url).into(binding.ivAlbum4)


               }
           }
    }
}
