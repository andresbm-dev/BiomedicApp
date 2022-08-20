package com.example.biomedicapp.register.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor() : ViewModel() {

    private val signUpState:MutableLiveData<Boolean> = MutableLiveData()
    private val signUpStateLiveData:LiveData<Boolean> = signUpState

}