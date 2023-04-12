package com.vrk.weatherinfo.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.vrk.weatherinfo.repository.WeatherRepository

class MainViewModelFactory(private val repository: WeatherRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(repository) as T
    }
}