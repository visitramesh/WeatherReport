package com.vrk.weatherinfo.viewmodel
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vrk.weatherinfo.data.WeatherReport
import com.vrk.weatherinfo.repository.Response
import com.vrk.weatherinfo.repository.WeatherRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val repository: WeatherRepository) : ViewModel() {
    var location: String? = null
    var loactionStatus = MutableLiveData<Boolean?>()

    fun setOnSearchbtnClick() {
        if(location != null){
                loactionStatus.value = true
                viewModelScope.launch(Dispatchers.IO) {
                    repository.getWeather(location!!.trim(), "metric")
                }
            }
        else{
            Log.d("MainViewModel","location is null ")
            loactionStatus.value = false
        }
    }

    val weather: LiveData<Response<WeatherReport>>
        get() = repository.weather


}