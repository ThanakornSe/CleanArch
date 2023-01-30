package com.example.domain.useCases

import com.example.domain.model.CoinDomain
import com.example.domain.repository.CoinRepository
import com.example.domain.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(): Flow<Resource<List<CoinDomain>>> = flow {
        try {
            emit(Resource.Loading())
            val coins = repository.getCoins()
            emit(Resource.Success(coins))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection!"))
        }
    }

//    suspend fun getData():Flow<Resource<List<CoinDomain>>> = flow {
//        try {
//            emit(Resource.Loading())
//            val coins: List<CoinDomain> = repository.getCoins()
//            emit(Resource.Success(coins))
//        } catch (e:IOException) {
//            emit(Resource.Error("Couldn't reach server. Check your internet connection!"))
//        }
//    }
}