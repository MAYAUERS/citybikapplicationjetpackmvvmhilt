package com.demo.citybikapplicationjetpackmvvmhilt.repository

import com.demo.citybikapplicationjetpackmvvmhilt.model.CityBike
import com.demo.citybikapplicationjetpackmvvmhilt.network.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response
import javax.inject.Inject

class CityBikeRepository @Inject constructor (private val apiService: ApiService) {

    suspend fun getCityBikeData():Response<CityBike> = apiService.getCityBikeData()

   // suspend fun getCityBikeData():Flow<CityBike> = apiService.getCityBikeData().flowOn(Dispatchers.IO)
}