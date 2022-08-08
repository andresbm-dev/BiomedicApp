package com.example.biomedicapp.login

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import cn.pedant.SweetAlert.SweetAlertDialog
import com.example.biomedicapp.home.activity.MainActivity
import com.example.biomedicapp.databinding.ActivityLoginBinding
import com.example.biomedicapp.register.RegisterActivity
import com.example.biomedicapp.utils.BioApplication.Companion.preferences

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private var emailUser : String? = null
    private var passwordUser: String ?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        checkUserValues()

        binding.bottomStart.setOnClickListener {
            validateUser()
        }

        binding.tvRegister.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }

    private fun checkUserValues() {
        if (preferences.getEmail().isNotEmpty()){
            goHome()
        }
    }

    private fun validateUser() {
        emailUser = binding.emailUser.text.toString()
        passwordUser = binding.passwordUser.text.toString()
        if (!emailUser.isNullOrEmpty() && !passwordUser.isNullOrEmpty()){
            if (emailUser == preferences.getEmail() && passwordUser == preferences.getPassword())
                goHome()
            else{
                showAlertError("Correo o Contraseña incorrectos")
            }

        }
        else{
            showAlertError("Campos Incompletos \n Favor llenar TODOS los campos ")
        }
    }

    private fun goHome() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    private fun showAlertError(message : String) {
        SweetAlertDialog(this, SweetAlertDialog.ERROR_TYPE)
            .setTitleText("Ooops..")
            .setContentText(message)
            .show()
    }
}