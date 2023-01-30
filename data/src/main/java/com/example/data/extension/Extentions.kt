package com.example.data.extension

import com.example.data.model.CoinNetwork
import com.example.domain.model.CoinDomain

fun CoinNetwork.toCoin(): CoinDomain {
    return CoinDomain(
        id, isActive, name, rank, symbol
    )
}