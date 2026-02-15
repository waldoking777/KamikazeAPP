package com.muaythai.kamikaze

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LocationDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_location_detail)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.location_detail)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val locationId = intent.getStringExtra("location_id")
        val location = locationId?.let { LocationRepository.getLocationById(it) }

        if (location != null) {
            val toolbarTitle = findViewById<TextView>(R.id.toolbar_title)
            val instructorName = findViewById<TextView>(R.id.instructor_name)
            val direccionText = findViewById<TextView>(R.id.direccion_text)
            val telefonoText = findViewById<TextView>(R.id.telefono_text)
            val emailText = findViewById<TextView>(R.id.email_text)
            val locationImage = findViewById<ImageView>(R.id.location_image)

            toolbarTitle.text = location.name
            instructorName.text = location.instructor
            direccionText.text = location.address
            telefonoText.text = location.phone
            emailText.text = location.email
            locationImage.setImageResource(location.imageResId)
        }
    }
}
