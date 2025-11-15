package com.example.atc_app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.atc_app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNavigation.setOnItemSelectedListener { item ->
            var selectedFragment: Fragment? = null
            when (item.itemId) {
                R.id.nav_order -> {
                    selectedFragment = OrderFragment()
                }
                R.id.nav_map -> {
                    selectedFragment = MapFragment()
                }
                R.id.nav_signature -> {
                    selectedFragment = SignatureFragment()
                }
                R.id.nav_report -> {
                    selectedFragment = ReportFragment()
                }
                R.id.nav_chat -> {
                    selectedFragment = ChatFragment()
                }
            }
            if (selectedFragment != null) {
                supportFragmentManager.beginTransaction().replace(R.id.fragment_container, selectedFragment).commit()
            }
            true
        }

        // Set default fragment
        if (savedInstanceState == null) {
            binding.bottomNavigation.selectedItemId = R.id.nav_order
        }
    }
}