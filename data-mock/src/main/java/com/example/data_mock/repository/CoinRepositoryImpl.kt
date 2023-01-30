package com.example.data_mock.repository

import com.example.domain.model.CoinDomain
import com.example.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor() : CoinRepository{

    private val coinDomainLists = arrayListOf(
        CoinDomain("1", false, "Bitcoin", 12, "BTC"),
        CoinDomain("2", true, "Dogecoin", 12, "DOGE")
    )

    override suspend fun getCoins(): List<CoinDomain> = coinDomainLists

}