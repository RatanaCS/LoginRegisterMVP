package com.sumuzu.loginregistermvp.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ConfigNetwork {

    companion object{

        fun getNetwork(): UserService{
            val retrofit = Retrofit.Builder()
                .baseUrl("http://192.168.0.36/loginregsitermvp/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            val service = retrofit.create(UserService::class.java)
            return service

        }

    }

}