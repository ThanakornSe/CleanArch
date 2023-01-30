package com.example.data.api

import com.example.data.model.CoinNetwork
import retrofit2.http.GET

interface CoinPaprikaApi {

    @GET("/v1/coins")
    suspend fun getCoins():List<CoinNetwork>
}