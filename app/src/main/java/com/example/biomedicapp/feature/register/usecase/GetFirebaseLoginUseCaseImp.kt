package com.example.biomedicapp.feature.register.usecase

import com.example.biomedicapp.domain.model.UserFirebase
import com.example.biomedicapp.domain.repository.FirebaseRepository
import com.example.biomedicapp.domain.repository.FirebaseRepositoryImp
import com.example.biomedicapp.utils.Result
import com.example.biomedicapp.domain.repository.FirestoreUserRepositoryImp
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetFirebaseLoginUseCaseImp @Inject constructor(
    private val repository: FirebaseRepositoryImp,
    private val userRepository: FirestoreUserRepositoryImp
) : GetFirebaseLoginUseCase {

    override suspend fun getLogin(email: String, password: String): Flow<Result<UserFirebase>> = flow {
        var userId =  repository.login(email, password)
        if (userId.isNotEmpty()){
            val user = userRepository.getUser(userId)
            emit(Result.Success(user))
        }else{
            emit(Result.Error("Login Error"))
        }
    }

    override suspend fun getSignUp(email: String, password: String):  Flow<Result<Boolean>> = flow{
        var userId =  repository.sigUp(email, password)
        if (userId.isNotEmpty()){
            userRepository.createUser(UserFirebase(email = email, uid = userId))
            emit(Result.Success(true))

        }else{
            emit(Result.Error("Signup Error"))

        }

    }
}