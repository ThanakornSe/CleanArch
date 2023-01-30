package com.example.data.repository

import com.example.data.api.CoinPaprikaApi
import com.example.data.extension.toCoin
import com.example.domain.model.CoinDomain
import com.example.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api:CoinPaprikaApi
):CoinRepository {

    override suspend fun getCoins(): List<CoinDomain> {
        return api.getCoins().map { it.toCoin() }
    }

}