package com.vrk.weatherinfo.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.vrk.weatherinfo.repository.WeatherRepository
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

internal class MainViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    lateinit var viewmodel: MainViewModel

    @Mock
    lateinit var weatherRepository: WeatherRepository


    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        this.viewmodel = MainViewModel(weatherRepository)
    }

    @Test
    fun fetchweatherDetails_positiveResponse() {
        this.viewmodel.setOnSearchbtnClick()
    }

}