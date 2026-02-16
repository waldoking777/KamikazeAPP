package com.muaythai.kamikaze

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class LocationAdapter(private val locations: List<Location>) :
    RecyclerView.Adapter<LocationAdapter.LocationViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.location_item, parent, false)
        return LocationViewHolder(view)
    }

    override fun onBindViewHolder(holder: LocationViewHolder, position: Int) {
        val location = locations[position]
        holder.bind(location)
    }

    override fun getItemCount(): Int = locations.size

    inner class LocationViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameTextView: TextView = itemView.findViewById(R.id.location_name)

        fun bind(location: Location) {
            nameTextView.text = location.name
            itemView.setOnClickListener {
                val context = itemView.context
                val intent = Intent(context, LocationDetailActivity::class.java).apply {
                    putExtra("location_id", location.id)
                }
                context.startActivity(intent)
            }
        }
    }
}
