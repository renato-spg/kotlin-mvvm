package com.spg.learnviewmodel.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.spg.learnviewmodel.model.LoginResult
import com.spg.learnviewmodel.repository.LoginRepository

class LoginViewModel : ViewModel() {

    private val repository = LoginRepository()

    private val _loginResult = MutableLiveData<LoginResult>()
     val _mNotification = MutableLiveData<String>()

    fun mNotify():LiveData<String>{
        return _mNotification
    }
    fun loginResult():LiveData<LoginResult>{
        return _loginResult
    }

    fun login(username:String, pass:String){
        val result = repository.login(user = username, pass = pass)
       if(result.success){
           _mNotification.postValue("Acesso Autorizado")
       }else{
           _mNotification.postValue("Acesso negado")
       }
        _loginResult.postValue(result)
    }

}

