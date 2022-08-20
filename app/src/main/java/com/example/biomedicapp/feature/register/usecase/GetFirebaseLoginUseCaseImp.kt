package com.example.biomedicapp.feature.register.usecase

import com.example.biomedicapp.domain.repository.FirebaseRepository
import com.example.biomedicapp.domain.repository.FirebaseRepositoryImp
import javax.inject.Inject

class GetFirebaseLoginUseCaseImp @Inject constructor(
    private val repository: FirebaseRepositoryImp
):GetFirebaseLoginUseCase{

    override suspend fun getLogin(email: String, password: String): Boolean {
        return repository.login(email, password)
    }

    override suspend fun getSignUp(email: String, password: String): Boolean {
        return repository.sigUp(email,password)
    }
}