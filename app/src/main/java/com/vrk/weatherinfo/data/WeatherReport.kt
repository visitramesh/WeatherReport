package com.vrk.weatherinfo.data

import com.vrk.weatherinfo.newdata.Clouds
import com.vrk.weatherinfo.newdata.Coord
import com.vrk.weatherinfo.newdata.Main
import com.vrk.weatherinfo.newdata.Sys
import com.vrk.weatherinfo.newdata.Wind

data class WeatherReport(
    val base: String,
    val clouds: Clouds,
    val cod: Int,
    val coord: Coord,
    val dt: Long,
    val id: Int,
    val main: Main,
    val name: String,
    val sys: Sys,
    val timezone: Int,
    val visibility: Int,
    val weather: List<WeatherList>,
    val wind: Wind
)