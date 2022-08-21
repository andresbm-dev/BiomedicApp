package com.example.biomedicapp.feature.register.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.biomedicapp.domain.model.UserFirebase
import com.example.biomedicapp.feature.register.usecase.GetFirebaseLoginUseCaseImp
import com.example.biomedicapp.utils.Result
import com.google.firebase.firestore.auth.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class RegisterViewModelImp @Inject constructor(
    private val getFirebaseLoginUseCase: GetFirebaseLoginUseCaseImp
) : ViewModel(), RegisterViewModel {

    private val loginState:MutableLiveData<Result<UserFirebase>> = MutableLiveData()
    val loginStateLiveData:LiveData<Result<UserFirebase>> = loginState

    private val signUpState:MutableLiveData<Result<Boolean>> = MutableLiveData()
    val signUpStateLiveData:LiveData<Result<Boolean>> = signUpState

    override fun getLogin(email: String, password: String) {
        viewModelScope.launch {
            withContext(Dispatchers.IO){
               getFirebaseLoginUseCase.getLogin(email, password).onEach {
                    loginState.postValue(it)
                }.launchIn(viewModelScope)
            }
        }
    }

    override fun getSignUp(email: String, password: String) {
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                getFirebaseLoginUseCase.getSignUp(email, password).onEach {
                    signUpState.postValue(it)
                }.launchIn(viewModelScope)
            }
        }
    }

}