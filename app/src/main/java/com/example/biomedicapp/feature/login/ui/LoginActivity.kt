package com.example.biomedicapp.feature.login.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import cn.pedant.SweetAlert.SweetAlertDialog
import com.example.biomedicapp.feature.home.activity.MainActivity
import com.example.biomedicapp.databinding.ActivityLoginBinding
import com.example.biomedicapp.feature.register.ui.RegisterActivity
import com.example.biomedicapp.feature.register.viewmodel.RegisterViewModelImp
import com.example.biomedicapp.utils.BioApplication.Companion.preferences
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private var emailUser : String? = null
    private var passwordUser: String ?= null
    private val viewModel:RegisterViewModelImp by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        checkUserValues()

        viewModel.loginStateLiveData.observe(this,{
            if (it){
                goHome()
                storeData()
            }
            else
                showAlertError("Correo o contraseña invalidos")
        })
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
            viewModel.getLogin(emailUser!!,passwordUser!!)
        }
        else{
            showAlertError("Campos Incompletos \n Favor llenar TODOS los campos ")
        }
    }

    private fun goHome() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
    private fun storeData() {
        preferences.saveEmail(emailUser!!)
        preferences.savePassword(passwordUser!!)

    }

    private fun showAlertError(message : String) {
        SweetAlertDialog(this, SweetAlertDialog.ERROR_TYPE)
            .setTitleText("Ooops..")
            .setContentText(message)
            .show()
    }
}