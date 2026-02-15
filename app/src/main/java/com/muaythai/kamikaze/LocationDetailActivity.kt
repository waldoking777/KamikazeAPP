package com.muaythai.kamikaze

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class LocationDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_location_detail)

        val sedeName = intent.getStringExtra("sede_name")

        val toolbarTitle = findViewById<TextView>(R.id.toolbar_title)
        val instructorName = findViewById<TextView>(R.id.instructor_name)
        val direccionText = findViewById<TextView>(R.id.direccion_text)
        val telefonoText = findViewById<TextView>(R.id.telefono_text)
        val emailText = findViewById<TextView>(R.id.email_text)

        when (sedeName) {
            "Sede Norte" -> {
                toolbarTitle.text = "Sede Norte"
                instructorName.text = "Juan Pérez"
                direccionText.text = "Av. Amazonas y Naciones Unidas, Quito"
                telefonoText.text = "+593 98 765 4321"
                emailText.text = "sede.norte@kamikaze.com"
            }
            "Sede Valle" -> {
                toolbarTitle.text = "Sede Valle"
                instructorName.text = "Ana Gómez"
                direccionText.text = "Av. Interoceánica y Scalesia, Cumbayá"
                telefonoText.text = "+593 99 888 7777"
                emailText.text = "sede.valle@kamikaze.com"
            }
        }
    }
}
