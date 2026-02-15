package com.muaythai.kamikaze

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment

class LocationsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_locations, container, false)

        val sedeNorteCard = view.findViewById<CardView>(R.id.sede_norte_card)
        val sedeValleCard = view.findViewById<CardView>(R.id.sede_valle_card)

        sedeNorteCard.setOnClickListener {
            val intent = Intent(context, LocationDetailActivity::class.java)
            intent.putExtra("sede_name", "Sede Norte")
            startActivity(intent)
        }

        sedeValleCard.setOnClickListener {
            val intent = Intent(context, LocationDetailActivity::class.java)
            intent.putExtra("sede_name", "Sede Valle")
            startActivity(intent)
        }

        return view
    }
}
