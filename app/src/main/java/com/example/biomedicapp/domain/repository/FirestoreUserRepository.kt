package com.example.biomedicapp.domain.repository

import com.example.biomedicapp.domain.model.UserFirebase

interface FirestoreUserRepository {
    suspend fun createUser(user:UserFirebase):Boolean
    suspend fun getUser(uId:String): UserFirebase
}