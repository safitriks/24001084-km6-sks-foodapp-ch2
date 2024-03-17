package com.example.challenge2.presentation.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.challenge2.presentation.cataloglist.adapter.CatalogAdapter
import com.example.challenge2.presentation.cataloglist.adapter.CategoryAdapter
import com.example.challenge2.R
import com.example.challenge2.databinding.ActivityMainBinding
import com.example.challenge2.data.model.Catalog
import com.example.challenge2.data.model.Category

class MainActivity : AppCompatActivity() {
    private val binding : ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private var categoryadapter = CategoryAdapter()
    private var catalogadapter = CatalogAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }



}