package com.example.chapter6topic4mvvp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.chapter6topic4mvvp.model.ResponseDataCarItem
import com.example.chapter6topic4mvvp.network.RetrofitClientCar
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ViewModelCars : ViewModel(){
    var liveDataCar : MutableLiveData<List<ResponseDataCarItem>>

    init {
        liveDataCar = MutableLiveData()
    }

    fun getLDCar() : MutableLiveData<List<ResponseDataCarItem>> {
        return liveDataCar
    }

    fun callApiCar(){
        RetrofitClientCar.instance.getAllCar().enqueue(object :
            Callback<List<ResponseDataCarItem>> {
            override fun onResponse(call: Call<List<ResponseDataCarItem>>, response: Response<List<ResponseDataCarItem>>) {
                if (response.isSuccessful){
                    liveDataCar.postValue(response.body())
                }
                else{

                }
            }
            override fun onFailure(call: Call<List<ResponseDataCarItem>>, t: Throwable) {

            }
        })
    }
}