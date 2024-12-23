package com.demo.citybikapplicationjetpackmvvmhilt.network

import com.demo.citybikapplicationjetpackmvvmhilt.model.CityBike
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    //http://api.citybik.es/v2/networks
    @GET("networks")
    suspend fun getCityBikeData(): Response<CityBike>

   /* @GET("networks")
    suspend fun getCityBikeData(): Flow<CityBike>*/
}