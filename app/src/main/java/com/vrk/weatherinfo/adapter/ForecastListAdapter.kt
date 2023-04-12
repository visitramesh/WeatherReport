package com.vrk.weatherinfo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.vrk.weatherinfo.R
import com.vrk.weatherinfo.newdata.Main


open class ForecastListAdapter(private val forecastList: Main) : RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {

    lateinit var  temparaturelist: List<Main>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_row_child, parent, false)
        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val ItemsViewModel = temparaturelist?.get(position)
        val context : Context = holder.itemView.context
        if (ItemsViewModel != null) {
            holder.tmpTextView.text = context.getString(R.string.temparature) + " " +ItemsViewModel.temp.toString() + 0x00B0.toChar().toString() + "C"
            holder.humidityTextView.text = context.getString(R.string.humidity) + " " +ItemsViewModel.humidity.toString() +"\u2109"
            holder.maxTextView.text = context.getString(R.string.max_teparature) + " " +ItemsViewModel.temp_max.toString() + 0x00B0.toChar().toString() + "C"
            holder.minTextView.text = context.getString(R.string.min_temparature) + " " +ItemsViewModel.temp_min.toString() + 0x00B0.toChar().toString() + "C"

        }
            }
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val tmpTextView: TextView = itemView.findViewById(R.id.tmpTextView)
        val humidityTextView: TextView = itemView.findViewById(R.id.textViewHumidity)
        val maxTextView: TextView = itemView.findViewById(R.id.maxTmptextView)
        val minTextView: TextView = itemView.findViewById(R.id.minTmpTextView)
    }

    override fun getItemCount(): Int {
        val foreCastSet: Set<Main> = setOf(forecastList)
        temparaturelist = foreCastSet.toList()
        return temparaturelist.size
    }
}