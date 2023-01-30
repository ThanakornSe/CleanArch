package com.example.cleanarch.model

import com.example.domain.model.CoinDomain

data class CoinUiState(
    val isLoading:Boolean = false,
    val coinDomains:List<CoinDomain> = emptyList(),
    val error:String = ""
)
