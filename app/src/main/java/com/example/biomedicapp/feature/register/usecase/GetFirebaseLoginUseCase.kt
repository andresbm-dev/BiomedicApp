package com.example.biomedicapp.feature.register.usecase

interface GetFirebaseLoginUseCase {

    suspend  fun getLogin(email:String, password:String) : Boolean
    suspend  fun getSignUp(email:String, password:String) : Boolean

}