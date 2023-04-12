package com.vrk.weatherinfo.adapter

import android.content.Context
import android.os.Build
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.vrk.weatherinfo.R
import com.vrk.weatherinfo.data.Main
import com.vrk.weatherinfo.data.WeatherList
import com.vrk.weatherinfo.data.WeatherReport
import java.text.SimpleDateFormat
import java.util.*


open class WeatherListAdapter(private val weatherReport: WeatherReport) : RecyclerView.Adapter<WeatherListAdapter.ViewHolder>() {

    lateinit var  weatherReportList: List<WeatherReport>
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_cihild, parent, false)
        return ViewHolder(view)
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val ItemsViewModel = weatherReportList?.get(position)
        val context : Context = holder.itemView.context
        ItemsViewModel.let {
            holder.cloudTextView.text = context.getString(R.string.Name) + " " +ItemsViewModel!!.name.toString()
            val forecastListAdapter = ForecastListAdapter(ItemsViewModel.main)
            holder.recyclerView.layoutManager = LinearLayoutManager(holder.itemView.context, LinearLayoutManager.HORIZONTAL,false)
            holder.recyclerView.adapter = forecastListAdapter
        }

    }



    override fun getItemCount(): Int {
        val foreCastSet: Set<WeatherReport> = setOf(weatherReport)
        weatherReportList = foreCastSet.toList()
        return weatherReportList.size
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val cloudTextView: TextView = itemView.findViewById(R.id.name)
        val recyclerView: RecyclerView = itemView.findViewById(R.id.childRecyclerView)

    }
}