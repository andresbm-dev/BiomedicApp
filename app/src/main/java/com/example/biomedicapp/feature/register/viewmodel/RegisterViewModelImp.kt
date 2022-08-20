package com.example.biomedicapp.feature.register.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.biomedicapp.feature.register.usecase.GetFirebaseLoginUseCaseImp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class RegisterViewModelImp @Inject constructor(
    private val getFirebaseLoginUseCase: GetFirebaseLoginUseCaseImp
) : ViewModel(), RegisterViewModel {

    private val loginState:MutableLiveData<Boolean> = MutableLiveData()
    val loginStateLiveData:LiveData<Boolean> = loginState

    private val signUpState:MutableLiveData<Boolean> = MutableLiveData()
    val signUpStateLiveData:LiveData<Boolean> = signUpState

    override fun getLogin(email: String, password: String) {
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                loginState.postValue(getFirebaseLoginUseCase.getLogin(email, password))
            }
        }
    }

    override fun getSignUp(email: String, password: String) {
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                signUpState.postValue(getFirebaseLoginUseCase.getSignUp(email, password))
            }
        }
    }

}