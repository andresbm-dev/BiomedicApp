package com.example.biomedicapp.account

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.biomedicapp.databinding.ActivityAccountBinding
import com.example.biomedicapp.home.activity.MainActivity
import com.example.biomedicapp.login.ui.LoginActivity
import com.example.biomedicapp.utils.BioApplication.Companion.preferences

class AccountActivity : AppCompatActivity() {
    lateinit var binding :ActivityAccountBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAccountBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            preferences.wipe()
            goLogin()
        }
        binding.tvName.text = preferences.getName()
        binding.tvEmail.text = preferences.getEmail()
        binding.tvCity.text = preferences.getCity()
        binding.toolBar.setOnClickListener {
            onBackPressed()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        goHome()
    }

    private fun goHome() {
        startActivity(Intent(this, MainActivity::class.java))
    }

    private fun goLogin() {
        startActivity(Intent(this, LoginActivity::class.java))
    }
}