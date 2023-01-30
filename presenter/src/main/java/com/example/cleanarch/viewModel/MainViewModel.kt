package com.example.cleanarch.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cleanarch.model.CoinUiState
import com.example.domain.useCases.GetCoinsUseCase
import com.example.domain.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getCoinsUseCase: GetCoinsUseCase
) : ViewModel() {

    private val _state = MutableLiveData<CoinUiState>()
    val state: LiveData<CoinUiState> = _state

    init {
        getCoins()
    }

    private fun getCoins() {
        getCoinsUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = CoinUiState(coinDomains = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value =
                        CoinUiState(error = result.message ?: "An unexpected error occurred")
                }
                is Resource.Loading -> {
                    _state.value = CoinUiState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

//    private fun getData() {
//        viewModelScope.launch {
//            getCoinsUseCase.getData().collect {
//                when (it) {
//                    is Resource.Loading -> {
//                        _state.value = CoinUiState(isLoading = true)
//                    }
//                    is Resource.Success -> {
//                        _state.value = CoinUiState(coinDomains = it.data?: emptyList())
//                    }
//                    is Resource.Error -> {
//                        _state.value = CoinUiState(error = it.message?:"An unexpected error occurred")
//                    }
//                }
//            }
//        }
//    }
}