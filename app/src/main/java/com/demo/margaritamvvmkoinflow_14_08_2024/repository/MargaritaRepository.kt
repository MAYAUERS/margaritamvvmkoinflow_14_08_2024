package com.demo.margaritamvvmkoinflow_14_08_2024.repository

import com.demo.margaritamvvmkoinflow_14_08_2024.model.Margarita
import com.demo.margaritamvvmkoinflow_14_08_2024.network.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class MargaritaRepository(private var apiService: ApiService) {

    fun getMargaritaData(): Flow<Margarita> = flow {
       // val result = apiService.getMargarita("margarita")
        val result = apiService.getMargarita()
        emit(result)
    }.flowOn(Dispatchers.IO)
}