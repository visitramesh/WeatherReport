package com.vrk.weatherinfo.ui


import android.Manifest
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.vrk.weatherinfo.R
import com.vrk.weatherinfo.adapter.WeatherListAdapter
import com.vrk.weatherinfo.data.WeatherApplication
import com.vrk.weatherinfo.databinding.ActivityMainBinding
import com.vrk.weatherinfo.repository.Response
import com.vrk.weatherinfo.viewmodel.MainViewModel
import com.vrk.weatherinfo.viewmodel.MainViewModelFactory


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel
    private lateinit var weatherListAdapter: WeatherListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val repository = (application as WeatherApplication).weatherRepository

        mainViewModel =
            ViewModelProvider(this, MainViewModelFactory(repository)).get(MainViewModel::class.java)

        mainViewModel.loactionStatus.observe(this, Observer {
            if(mainViewModel.loactionStatus.value == false) {
                Toast.makeText(this,"Error 404: No Location found",Toast.LENGTH_SHORT).show()
            }
        })

        mainViewModel.weather.observe(this) { fetchedData ->
            when(fetchedData){
                is Response.Error ->{
                    fetchedData.errorMessage
                    Toast.makeText(this,fetchedData.errorMessage,Toast.LENGTH_SHORT).show()
                }
                is Response.Success ->{
                    fetchedData.data?.let {
                        Log.d("fetchdat","it "+it)
                        binding.parentRecyclerView.layoutManager = LinearLayoutManager(this,
                            LinearLayoutManager.VERTICAL,false)
                            fetchedData.data.weather.let {
                            weatherListAdapter = WeatherListAdapter(fetchedData.data)
                            binding.parentRecyclerView.adapter = weatherListAdapter
                        }

                    }

                }
            }
        }

        binding.mainViewModel = mainViewModel

    }

}