package com.example.biomedicapp.utils

import android.content.Context

class PreferencesClass (private val context : Context) {
    val storage = context.getSharedPreferences(UtilsConstants.SHARED_NAME, 0)

    fun saveEmail(email:String){
        storage.edit().putString(UtilsConstants.SHARED_EMAIL, email).apply()
    }
    fun saveName(name:String){
        storage.edit().putString(UtilsConstants.SHARED_USER, name).apply()
    }
    fun savePassword(password:String){
        storage.edit().putString(UtilsConstants.SHARED_PASSWORD, password).apply()
    }
    fun saveCity(city:String){
        storage.edit().putString(UtilsConstants.SHARED_CITY, city).apply()
    }

    fun getEmail():String{
        return storage.getString(UtilsConstants.SHARED_EMAIL,"") ?: ""
    }

    fun getPassword():String{
        return storage.getString(UtilsConstants.SHARED_PASSWORD,"") ?: ""
    }
    fun getName():String{
        return storage.getString(UtilsConstants.SHARED_USER,"") ?: ""
    }
    fun getCity():String{
        return storage.getString(UtilsConstants.SHARED_CITY ,"") ?: ""
    }
    fun wipe(){
        storage.edit().clear().apply()
    }
}