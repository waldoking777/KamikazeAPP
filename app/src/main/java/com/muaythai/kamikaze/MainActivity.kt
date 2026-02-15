package com.muaythai.kamikaze

import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updatePadding
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        bottomNavigationView = findViewById(R.id.bottom_navigation)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())

            // Apply padding to the main view to avoid content overlapping with the status bar
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, 0)

            // Apply padding to the bottom navigation view to avoid it overlapping with the gesture navigation bar
            bottomNavigationView.updatePadding(bottom = systemBars.bottom)

            // Return the insets so that they can be consumed by other views
            insets
        }

        // Load the default fragment
        if (savedInstanceState == null) {
            loadFragment(HomeFragment())
        }

        bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.navigation_home -> {
                    loadFragment(HomeFragment())
                    true
                }
                R.id.navigation_school -> {
                    loadFragment(SchoolFragment())
                    true
                }
                R.id.navigation_locations -> {
                    loadFragment(LocationsFragment())
                    true
                }
                R.id.navigation_classes -> {
                    loadFragment(ClassesFragment())
                    true
                }
                R.id.navigation_contact -> {
                    loadFragment(ContactFragment())
                    true
                }
                else -> false
            }
        }

        // Handle back press
        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (bottomNavigationView.selectedItemId != R.id.navigation_home) {
                    bottomNavigationView.selectedItemId = R.id.navigation_home
                    loadFragment(HomeFragment())
                } else {
                    // If on home, allow default back press (exit app)
                    isEnabled = false
                    onBackPressedDispatcher.onBackPressed()
                    isEnabled = true
                }
            }
        }
        onBackPressedDispatcher.addCallback(this, callback)
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}
