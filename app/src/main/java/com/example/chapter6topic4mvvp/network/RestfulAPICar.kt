package com.example.chapter6topic4mvvp.network

import com.example.chapter6topic4mvvp.model.ResponseDataCarItem
import retrofit2.Call
import retrofit2.http.GET

interface RestfulAPICar {
    @GET("admin/car")
    fun getAllCar() : Call<List<ResponseDataCarItem>>
}