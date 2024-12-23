package com.demo.citybikapplicationjetpackmvvmhilt.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.demo.citybikapplicationjetpackmvvmhilt.model.CityBike
import com.demo.citybikapplicationjetpackmvvmhilt.model.CityBikeList
import com.demo.citybikapplicationjetpackmvvmhilt.repository.CityBikeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch

import javax.inject.Inject

@HiltViewModel
class CityBikeViewModel
@Inject constructor(private val cityBikeRepository: CityBikeRepository):ViewModel() {


    val cityBike:LiveData<List<CityBikeList>> get() = _cityBike
    private val _cityBike = MutableLiveData<List<CityBikeList>>()

    val cityBikeError:LiveData<String> get() = _cityBikeError
    private val _cityBikeError = MutableLiveData<String>()


    fun getCityBikeDataFromVM(){
        viewModelScope.launch {
            val response = cityBikeRepository.getCityBikeData()
            if (response.isSuccessful){
                _cityBike.value = response.body()?.networks
            }else{
                _cityBikeError.value = response.errorBody().toString()
            }
        }
    }

}