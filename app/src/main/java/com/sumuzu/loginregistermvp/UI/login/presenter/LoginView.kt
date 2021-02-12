package com.sumuzu.loginregistermvp.UI.login.presenter

import com.sumuzu.loginregistermvp.UI.login.model.DataItem
import com.sumuzu.loginregistermvp.UI.login.model.ResponseLogin

interface LoginView {

    fun successLogin(msg: String, user : List<DataItem?>)
    fun errorLogin(msg : String)
//    fun empty()
//    fun noMatch()
//    fun startProgressBar()
//    fun hideProgressBar()

}