package com.example.biomedicapp.home.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.biomedicapp.home.fragments.HomeFragment
import com.example.biomedicapp.home.fragments.MaintenanceFragment
import com.example.biomedicapp.R
import com.example.biomedicapp.account.AccountActivity
import com.example.biomedicapp.databinding.ActivityMainBinding
import com.example.biomedicapp.home.fragments.CalibrateFragment
import com.example.biomedicapp.utils.BioApplication.Companion.preferences
import com.example.biomedicapp.utils.UtilsConstants
import java.util.prefs.Preferences

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getData()


        binding.toolBar.title = "Home Biomédicapp"

        binding.accountText.setOnClickListener {
            startActivity(Intent(this, AccountActivity::class.java))
        }

        loadFragment(HomeFragment())
        BottomnavigationFragments()


    }

    private fun getData() {
        val name = preferences.getName()
        val email = preferences.getEmail()
        val city = preferences.getCity()
        val password = preferences.getPassword()

        binding.name.text = name
        binding.cityMain.text = city
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