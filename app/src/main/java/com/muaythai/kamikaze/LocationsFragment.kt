package com.muaythai.kamikaze

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class LocationsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_locations, container, false)

        val locationsRecyclerView = view.findViewById<RecyclerView>(R.id.locations_recycler_view)
        locationsRecyclerView.layoutManager = LinearLayoutManager(context)

        val locations = LocationRepository.getLocations()
        val adapter = LocationAdapter(locations)
        locationsRecyclerView.adapter = adapter

        return view
    }
}
