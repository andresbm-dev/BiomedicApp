package com.example.biomedicapp.feature.register.usecase

import com.example.biomedicapp.domain.model.UserFirebase
import com.example.biomedicapp.utils.Result
import kotlinx.coroutines.flow.Flow

interface GetFirebaseLoginUseCase {

    suspend  fun getLogin(email:String, password:String) :Flow<Result<UserFirebase>>
    suspend  fun getSignUp(email:String, password:String) :Flow<Result<Boolean>>

}