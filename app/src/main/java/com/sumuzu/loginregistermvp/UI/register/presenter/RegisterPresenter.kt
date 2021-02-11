package com.sumuzu.loginregistermvp.UI.register.presenter

import com.sumuzu.loginregistermvp.UI.register.model.ResponseRegister
import com.sumuzu.loginregistermvp.network.ConfigNetwork
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterPresenter(val registerView : RegisterView) {

    fun regsiter(nama: String, email: String, password: String, passConfirm: String, nohp: String){

        if(nama.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty() && passConfirm.isNotEmpty() && nohp.isNotEmpty()) {

            if(password != passConfirm){
                registerView.noMatch()
            }else{
                ConfigNetwork.getNetwork().register(nama, email, password, nohp)
                    .enqueue(object : Callback<ResponseRegister> {
                        override fun onResponse(
                            call: Call<ResponseRegister>,
                            response: Response<ResponseRegister>
                        ) {


                            if (response.isSuccessful) {
                                val responseServer = response.body()
                                val message = response.body()?.message
                                val status = response.body()?.isSuccess

                                if (status ?: true) {
                                    responseServer?.let { registerView.successRegister(it) }
                                } else {
                                    registerView.errorRegister(message ?: "")
                                }

                            }


                        }

                        override fun onFailure(call: Call<ResponseRegister>, t: Throwable) {
                            registerView.errorRegister(t.localizedMessage)
                        }
                    })
            }

        }else{
            registerView.empty()
        }

    }
}