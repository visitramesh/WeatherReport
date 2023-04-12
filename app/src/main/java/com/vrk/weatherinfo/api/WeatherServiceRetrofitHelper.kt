package com.vrk.weatherinfo.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object WeatherServiceRetrofitHelper {
    private const val BASE_URL = "https://api.openweathermap.org/"

    fun getRetrofitInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}