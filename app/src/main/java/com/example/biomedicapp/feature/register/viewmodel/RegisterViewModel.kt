package com.example.biomedicapp.feature.register.viewmodel

interface RegisterViewModel {
    fun getLogin(email:String, password:String)
    fun getSignUp(email:String, password:String)

}