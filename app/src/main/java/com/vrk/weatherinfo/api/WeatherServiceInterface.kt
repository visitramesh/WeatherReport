package com.vrk.weatherinfo.api

import com.vrk.weatherinfo.data.WeatherReport
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

const val API_KEY: String = "558b0540074224c1579137c1475d5559"

interface WeatherServiceInterface {

    @GET("data/2.5/weather?appid=$API_KEY")
    suspend fun getWeather(
        @Query("q") city: String,
        @Query("units") units: String
    ): Response<WeatherReport>
}
