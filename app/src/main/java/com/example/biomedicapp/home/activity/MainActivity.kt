package com.example.biomedicapp.home.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.biomedicapp.home.fragments.HomeFragment
import com.example.biomedicapp.home.fragments.MaintenanceFragment
import com.example.biomedicapp.R
import com.example.biomedicapp.databinding.ActivityMainBinding
import com.example.biomedicapp.home.fragments.CalibrateFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.toolBar.title = "Home Biomédicapp"

        loadFragment(HomeFragment())
        BottomnavigationFragments()

    }

    private fun BottomnavigationFragments() {
        binding.bottomNavigation.setOnItemSelectedListener { item->
            when(item.itemId) {
             R.id.Home ->{
                 loadFragment(HomeFragment())
                 true
             }
                R.id.maintenance -> {
                    loadFragment(MaintenanceFragment())
                    true
                }
                R.id.calibrate -> {
                    loadFragment(CalibrateFragment())
                    true
                }
                else -> false
            }
        }
    }

    private  fun loadFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container, fragment)
            commit()
        }
    }

}