package com.sumuzu.loginregistermvp.UI.login.presenter

import com.sumuzu.loginregistermvp.UI.login.model.ResponseLogin
import com.sumuzu.loginregistermvp.UI.register.presenter.RegisterView
import com.sumuzu.loginregistermvp.network.ConfigNetwork
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginPresenter(val loginView : LoginView) {

    fun login(email : String, password : String){

        if(email.isNotEmpty() && password.isNotEmpty()){

            ConfigNetwork.getNetwork().login(email, password).enqueue(object : Callback<ResponseLogin>{
                override fun onResponse(call: Call<ResponseLogin>, response: Response<ResponseLogin>) {

                    if(response.isSuccessful){
                        val status = response.body()?.isSuccess
                        val message = response.body()?.message

                        if(status ?: true){
                            message?.let { response.body()!!.data?.let { it1 ->
                                loginView.successLogin(it,
                                    it1
                                )
                            } }
                        } else{
                            loginView.errorLogin(message ?: "")
                        }

                    }

                }

                override fun onFailure(call: Call<ResponseLogin>, t: Throwable) {
                    loginView.errorLogin(t.localizedMessage)
                }
            })


        }else{
            loginView.errorLogin("email dan password harus terisi")
        }



    }

}