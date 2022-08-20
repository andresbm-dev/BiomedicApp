package com.example.biomedicapp.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.biomedicapp.login.ui.LoginActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {3
        super.onCreate(savedInstanceState)
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }
    override fun onDestroy() {
        super.onDestroy()
        finish()
    }
    override fun onRestart() {
        super.onRestart()
        finish()
    }

}         