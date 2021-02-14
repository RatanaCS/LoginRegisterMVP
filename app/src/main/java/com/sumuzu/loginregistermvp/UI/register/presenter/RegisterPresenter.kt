package com.sumuzu.loginregistermvp.UI.register.presenter

import com.sumuzu.loginregistermvp.UI.register.model.ResponseRegister
import com.sumuzu.loginregistermvp.network.ConfigNetwork
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterPresenter(val registerView : RegisterView) {

    fun register(nama: String, email: String, password: String, passConfirm: String, nohp: String){

        registerView.startProgressBar()

        if(nama.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty() && passConfirm.isNotEmpty() && nohp.isNotEmpty()) {

            registerView.hideProgressBar()

            if(password != passConfirm){
                registerView.noMatch()
                registerView.hideProgressBar()
            }else if(password.length < 6){
                registerView.errorRegister("password minimal 6 karakter")
                registerView.hideProgressBar()
            } else{
//                registerView.hideProgressBar()

                //RX
                ConfigNetwork.getNetwork().register(nama, email, password, nohp).subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({
                        registerView.successRegister(it)
                    },{
                        registerView.errorRegister(it.localizedMessage)
                    })

                //Native
//                ConfigNetwork.getNetwork().register(nama, email, password, nohp)
//                    .enqueue(object : Callback<ResponseRegister> {
//                        override fun onResponse(
//                            call: Call<ResponseRegister>,
//                            response: Response<ResponseRegister>
//                        ) {
//
//                            if (response.isSuccessful) {
//
//                                val responseServer = response.body()
//                                val message = response.body()?.message
//                                val status = response.body()?.isSuccess
//
//                                if (status ?: true) {
//                                    responseServer?.let { registerView.successRegister(it) }
//                                } else {
//                                    registerView.errorRegister(message ?: "")
//                                }
//
//                                registerView.hideProgressBar()
//
//                            }
//
//                        }
//
//                        override fun onFailure(call: Call<ResponseRegister>, t: Throwable) {
//                            registerView.errorRegister(t.localizedMessage)
//                            registerView.hideProgressBar()
//                        }
//                    })
            }

        }else{
            registerView.empty()
            registerView.hideProgressBar()
        }

    }
}