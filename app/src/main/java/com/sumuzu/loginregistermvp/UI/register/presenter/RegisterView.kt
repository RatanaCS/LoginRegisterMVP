package com.sumuzu.loginregistermvp.UI.register.presenter

import com.sumuzu.loginregistermvp.UI.register.model.ResponseRegister

interface RegisterView {

    fun successRegister(response: ResponseRegister)
    fun errorRegister(msg : String)
    fun empty()
    fun noMatch()
    fun startProgressBar()
    fun hideProgressBar()

}