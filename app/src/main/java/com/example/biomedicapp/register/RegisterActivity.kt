package com.example.biomedicapp.register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.biomedicapp.databinding.ActivityRegisterBinding
import com.example.biomedicapp.home.activity.MainActivity
import com.example.biomedicapp.login.LoginActivity

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toolBar.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
        binding.bottomStart.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}