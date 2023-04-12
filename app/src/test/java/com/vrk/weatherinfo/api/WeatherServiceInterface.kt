package com.vrk.weatherinfo.api

import com.vrk.weatherinfo.data.WeatherReport
import okhttp3.OkHttpClient
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

const val API_KEY: String = "558b0540074224c1579137c1475d5559"
@RunWith(MockitoJUnitRunner::class)
class WeatherServiceInterfaceTest {

    @Mock
    private lateinit var apiService: WeatherServiceInterface
    private val BASE_URL = "https://api.openweathermap.org/"

    @Before
    fun createService() {
        val OkHttpClient = OkHttpClient.Builder()
        apiService = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient.build())
            .build()
            .create(WeatherServiceInterface::class.java)
    }

    @Test
    suspend fun getWeatherDetails() {
//    try {
//        val response: Response = apiService.getWeather("kerala", "matrics")
//        assesrtEual(response.code, 200)
//    } catch(e: IOExecption) {
//        e.printStackTrace()
//    }
    }
}
