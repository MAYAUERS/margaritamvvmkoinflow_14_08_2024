package com.demo.margaritamvvmkoinflow_14_08_2024.di

import com.demo.margaritamvvmkoinflow_14_08_2024.network.ApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    single { provideRetrofit(okHttpClient = get()) }
    factory { provideApiService(retrofit = get()) }
    factory { provideOkHttpClient(httpLoggingInterceptor = get()) }
    factory { HttpLoggingInterceptor() }
}

//https://www.thecocktaildb.com/api/json/v1/1/search.php?s=margarita
fun provideRetrofit(okHttpClient: OkHttpClient):Retrofit =
    Retrofit.Builder().baseUrl("https://www.thecocktaildb.com/")
    .addConverterFactory(GsonConverterFactory.create())
    .client(okHttpClient)
    .build()

fun provideOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor):OkHttpClient =
    OkHttpClient.Builder()
    .addInterceptor(httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY))
    .build()

fun provideApiService(retrofit: Retrofit):ApiService = retrofit.create(ApiService::class.java)