package com.vrk.weatherinfo.repository

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.vrk.weatherinfo.api.WeatherServiceInterface
import com.vrk.weatherinfo.data.WeatherReport
import com.vrk.weatherinfo.util.NetworkUtils

class WeatherRepository(
    private val weatherServiceInterface: WeatherServiceInterface,
    private val applicationContext: Context
) {

    private val weatherLiveData = MutableLiveData<Response<WeatherReport>>()
    val weather: LiveData<Response<WeatherReport>>
        get() = weatherLiveData

    suspend fun getWeather(location: String, units: String) {
        if(NetworkUtils.isInternetAvailable(applicationContext)){
                val result = weatherServiceInterface.getWeather(location,units)
                if(result?.body() != null){
                    weatherLiveData.postValue(Response.Success(result.body()))
                }
                else{
                    weatherLiveData.postValue(Response.Error("Error 404: Location not found"))
                }
        }
        else{
            weatherLiveData.postValue(Response.Error("No Internet"))
        }

    }
}
