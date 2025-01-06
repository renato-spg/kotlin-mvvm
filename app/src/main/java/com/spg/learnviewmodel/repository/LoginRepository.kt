package com.spg.learnviewmodel.repository

import com.spg.learnviewmodel.model.LoginResult

class LoginRepository {

    private val validUsername = "admin"
    private val validPass = "1234"


   fun login(user:String, pass:String): LoginResult{

       return if(user.equals(validUsername, ignoreCase = true) && pass.equals(validPass,ignoreCase = true))
           LoginResult(true, "Logado com sucesso")
       else LoginResult(false, "Usuário ou senha incorretos")

   }


}