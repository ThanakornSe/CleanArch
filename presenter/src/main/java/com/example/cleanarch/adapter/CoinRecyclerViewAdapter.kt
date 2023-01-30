package com.example.cleanarch.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cleanarch.databinding.CoinRowBinding
import com.example.domain.model.CoinDomain

class CoinRecyclerViewAdapter(val coinDomainList:List<CoinDomain>):RecyclerView.Adapter<CoinRecyclerViewAdapter.CoinViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinViewHolder {
        val binding = CoinRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CoinViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CoinViewHolder, position: Int) {
        holder.bind(coinDomainList[position])
    }

    override fun getItemCount(): Int = coinDomainList.size

    inner class CoinViewHolder(val binding:CoinRowBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(coinDomain:CoinDomain) {
            binding.coinName.text = coinDomain.name
        }
    }

}