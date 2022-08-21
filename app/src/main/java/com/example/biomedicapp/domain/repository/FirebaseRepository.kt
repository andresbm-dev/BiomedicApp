package com.example.biomedicapp.domain.repository

interface FirebaseRepository {

    suspend fun login(emaill:String, password:String):String
    suspend fun sigUp(email:String,  passwrord:String):String
}