package com.demo.margaritamvvmkoinflow_14_08_2024.di

import com.demo.margaritamvvmkoinflow_14_08_2024.repository.MargaritaRepository
import com.demo.margaritamvvmkoinflow_14_08_2024.viewmodel.MargaritaViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

var dataModule = module {
    single { MargaritaRepository(apiService = get()) }
}

var viewmodelModule = module {
    viewModel { MargaritaViewModel(margaritaRepository = get()) }
}