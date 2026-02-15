package com.muaythai.kamikaze

import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigationView = findViewById(R.id.bottom_navigation)

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
