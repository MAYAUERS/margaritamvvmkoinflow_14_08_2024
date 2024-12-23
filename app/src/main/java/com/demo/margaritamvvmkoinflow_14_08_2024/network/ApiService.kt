package com.demo.margaritamvvmkoinflow_14_08_2024.network

import com.demo.margaritamvvmkoinflow_14_08_2024.model.Margarita
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
//https://www.thecocktaildb.com/api/json/v1/1/search.php?s=margarita
    @GET("api/json/v1/1/search.php?s=margarita")
    suspend fun getMargarita():Margarita

   /* @GET("api/json/v1/1/search.php")
    suspend fun getMargarita(@Query("s") s :String):Margarita

*/
    /*  //http://makeup-api.herokuapp.com/api/v1/products.json?brand=maybelline
      @GET("api/v1/products.json")
      suspend fun getMyblineData(@Query("brand") brand :String):List<MyblineData>*/
}