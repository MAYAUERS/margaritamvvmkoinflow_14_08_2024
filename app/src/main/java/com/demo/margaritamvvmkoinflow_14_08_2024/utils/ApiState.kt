package com.demo.margaritamvvmkoinflow_14_08_2024.utils

import com.demo.margaritamvvmkoinflow_14_08_2024.model.Margarita

sealed class ApiState {

    class Success(var data:Margarita):ApiState()
    class Failure(var msg:Throwable):ApiState()
    object Empty:ApiState()
    object Loading:ApiState()
}