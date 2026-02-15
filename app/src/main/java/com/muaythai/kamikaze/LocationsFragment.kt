package com.muaythai.kamikaze

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment

class LocationsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_locations, container, false)

        val locations = LocationRepository.getLocations()

        if (locations.size >= 2) {
            val sedeNorteCard = view.findViewById<CardView>(R.id.sede_norte_card)
            val sedeNorteName = view.findViewById<TextView>(R.id.sede_norte_name)
            sedeNorteName.text = getString(R.string.location_name_format, locations[0].name)
            sedeNorteCard.setOnClickListener {
                val intent = Intent(context, LocationDetailActivity::class.java)
                intent.putExtra("location_id", locations[0].id)
                startActivity(intent)
            }

            val sedeValleCard = view.findViewById<CardView>(R.id.sede_valle_card)
            val sedeValleName = view.findViewById<TextView>(R.id.sede_valle_name)
            sedeValleName.text = getString(R.string.location_name_format, locations[1].name)
            sedeValleCard.setOnClickListener {
                val intent = Intent(context, LocationDetailActivity::class.java)
                intent.putExtra("location_id", locations[1].id)
                startActivity(intent)
            }
        }

        return view
    }
}
