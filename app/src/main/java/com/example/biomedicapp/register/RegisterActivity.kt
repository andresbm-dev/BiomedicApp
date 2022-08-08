package com.example.biomedicapp.register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import cn.pedant.SweetAlert.SweetAlertDialog
import com.example.biomedicapp.R
import com.example.biomedicapp.databinding.ActivityRegisterBinding
import com.example.biomedicapp.home.activity.MainActivity
import com.example.biomedicapp.login.LoginActivity
import com.example.biomedicapp.utils.BioApplication.Companion.preferences
import com.example.biomedicapp.utils.Utils
import com.example.biomedicapp.utils.UtilsConstants

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    private var name: String? = null
    private var surName: String? = null
    private var city: String? = null
    private var email: String? = null
    private var password: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toolBar.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
        binding.bottomStart.setOnClickListener {
            validateData()

        }
        binding.bottomStartDisbale.setOnClickListener {
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
            storeData()
            goHome()

        }
        else{
            showAlertError()
        }
    }

    private fun goHome() {
        startActivity(Intent(this,MainActivity::class.java))
    }

    private fun showAlertError() {
        SweetAlertDialog(this,SweetAlertDialog.ERROR_TYPE)
            .setTitleText("Ooops..")
            .setContentText("Campos Incompletos \n Favor llenar TODOS los campos ")
            .show()
    }


    private fun storeData() {
        preferences.saveEmail(email!!)
        preferences.savePassword(password!!)
        preferences.saveName(name!!)
        preferences.saveCity(city!!)
    }

    private fun enabledButtonNext() {
        binding.bottomStartDisbale.visibility = View.GONE
        binding.bottomStart.visibility = View.VISIBLE

    }
}