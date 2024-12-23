package com.demo.margaritamvvmkoinflow_14_08_2024.viewmodel

import androidx.lifecycle.ViewModel
import com.demo.margaritamvvmkoinflow_14_08_2024.repository.MargaritaRepository
import com.demo.margaritamvvmkoinflow_14_08_2024.utils.ApiState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart

class MargaritaViewModel(private var margaritaRepository: MargaritaRepository):ViewModel() {

    var margaritaFlow : Flow<ApiState> = margaritaRepository.getMargaritaData().map {
        ApiState.Success(it)
    }.catch {
        ApiState.Failure(it)
    }.onStart { ApiState.Loading }
}