package com.example.biomedicapp.feature.register.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.activity.viewModels
import cn.pedant.SweetAlert.SweetAlertDialog
import com.example.biomedicapp.databinding.ActivityRegisterBinding
import com.example.biomedicapp.feature.login.ui.LoginActivity
import com.example.biomedicapp.feature.register.viewmodel.RegisterViewModelImp
import com.example.biomedicapp.utils.BioApplication.Companion.preferences
import com.example.biomedicapp.utils.Result
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay

@AndroidEntryPoint
class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    private val viewModel : RegisterViewModelImp by viewModels()
    private var name: String? = null
    private var surName: String? = null
    private var city: String? = null
    private var email: String? = null
    private var password: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.signUpStateLiveData.observe(this,{state->
            when(state) {
                is Result.Success -> {
                    onBackPressed()
                    //goLogin()
                    storeData()
                }
                is Result.Error ->{
                    showAlertError()
                }
            }
        })

        binding.toolBar.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
        binding.bottomStart.setOnClickListener {
            validateData()

        }

    }

    private fun validateData() {
        name = binding.tvName.text.toString()
        surName = binding.tvSurname.text.toString()
        city = binding.tvCity.text.toString()
        email = binding.tvEmail.text.toString()
        password = binding.tvPassword.text.toString()
        if (!name.isNullOrEmpty() && !surName.isNullOrEmpty() && !city.isNullOrEmpty() && !email.isNullOrEmpty() && !password.isNullOrEmpty()) {
            viewModel.getSignUp(email!!, password!!)
        }
        else{
            showAlertError()
        }
    }

    private fun goLogin() {
        startActivity(Intent(this@RegisterActivity, LoginActivity::class.java))
    }

    private fun showAlertError() {
        SweetAlertDialog(this,SweetAlertDialog.ERROR_TYPE)
            .setTitleText("Ooops..")
            .setContentText("Campos Incompletos \n Favor llenar TODOS los campos ")
            .show()
    }
    private fun showAlert() {
        SweetAlertDialog(this,SweetAlertDialog.SUCCESS_TYPE)
            .setTitleText("Correcto")
            .setContentText("Registro Correcto")
            .show()
    }

    private fun storeData() {
        preferences.saveEmail(email!!)
        preferences.savePassword(password!!)
        preferences.saveName(name!!)
        preferences.saveCity(city!!)
    }


}