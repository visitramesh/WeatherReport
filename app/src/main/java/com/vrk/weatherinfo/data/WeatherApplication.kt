package com.vrk.weatherinfo.data

import android.app.Application
import com.vrk.weatherinfo.api.WeatherServiceInterface
import com.vrk.weatherinfo.api.WeatherServiceRetrofitHelper
import com.vrk.weatherinfo.repository.WeatherRepository

class WeatherApplication : Application() {

    lateinit var weatherRepository : WeatherRepository

    override fun onCreate() {
        super.onCreate()
        initialize()
    }

    private fun initialize() {
        val weatherService = WeatherServiceRetrofitHelper.getRetrofitInstance().create(WeatherServiceInterface::class.java)
        weatherRepository = WeatherRepository(weatherService, applicationContext)
    }
}