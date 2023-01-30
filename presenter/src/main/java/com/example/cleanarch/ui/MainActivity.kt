package com.example.cleanarch.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.core.view.isVisible
import com.example.cleanarch.adapter.CoinRecyclerViewAdapter
import com.example.cleanarch.databinding.ActivityMainBinding
import com.example.cleanarch.viewModel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val binding:ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private lateinit var coinAdapter:CoinRecyclerViewAdapter
    private val viewModel:MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        viewModel.state.observe(this) {
            if (!it.isLoading) {
                binding.progressBar.isVisible = false
                if (it.error.isNotBlank()) {
                    binding.errorText.isVisible = true
                    binding.errorText.text = it.error
                }else {
                    binding.recyclerView.isVisible = true
                    coinAdapter = CoinRecyclerViewAdapter(it.coinDomains)
                    binding.recyclerView.adapter = coinAdapter
                }
            }
        }
    }
}