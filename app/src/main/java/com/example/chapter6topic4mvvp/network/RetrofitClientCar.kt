package com.example.chapter6topic4mvvp.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClientCar {
    const val BASE_URL = "https://rent-cars-api.herokuapp.com/"

    private  val logging : HttpLoggingInterceptor
        get(){
            val httpLoggingInterceptor = HttpLoggingInterceptor()
            return httpLoggingInterceptor.apply {
                httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            }
        }

    private val client = OkHttpClient.Builder().addInterceptor(logging).build()

    val instance : RestfulAPICar by lazy {
        val retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).client(client).build()
        retrofit.create(RestfulAPICar::class.java)
    }
}