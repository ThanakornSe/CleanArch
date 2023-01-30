package com.example.domain.repository

import com.example.domain.model.CoinDomain

interface CoinRepository {
    suspend fun getCoins():List<CoinDomain>
}