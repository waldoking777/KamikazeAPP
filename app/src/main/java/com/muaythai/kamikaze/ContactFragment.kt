package com.muaythai.kamikaze

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.fragment.app.Fragment

class ContactFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_contact, container, false)

        val facebookIcon = view.findViewById<ImageView>(R.id.icon_facebook)
        val instagramIcon = view.findViewById<ImageView>(R.id.icon_instagram)
        val whatsappIcon = view.findViewById<ImageView>(R.id.icon_whatsapp)
        val tiktokIcon = view.findViewById<ImageView>(R.id.icon_tiktok)

        facebookIcon.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, "https://www.facebook.com/kamikazeartesmarcialesmuaythai".toUri())
            startActivity(intent)
        }

        instagramIcon.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, "https://www.instagram.com/kamikaze_artes_marciales".toUri())
            startActivity(intent)
        }

        whatsappIcon.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, "https://api.whatsapp.com/send?phone=593984470526".toUri())
            startActivity(intent)
        }

        tiktokIcon.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, "https://www.tiktok.com/@kamikazeartesmarciales".toUri())
            startActivity(intent)
        }

        return view
    }
}
