package com.example.lovecat4

import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity

import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.example.lovecat4.api.RetrofitInstance
import com.example.lovecat4.data.CatItemAdapter
import com.example.lovecat4.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val itemAdapter by lazy { CatItemAdapter() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.list.adapter=itemAdapter
           binding.catbutton.setOnClickListener {
               lifecycleScope.launch {
                  var result= withContext(Dispatchers.IO){ RetrofitInstance.service.getImages(num = 10)}
                  itemAdapter.submitList(result)

               }
           }
    }
}
