package com.demo.citybikapplicationjetpackmvvmhilt.model

data class CityBike(var networks:List<CityBikeList>)
data class CityBikeList(var id:String,var name:String)
