package com.sumuzu.loginregistermvp.UI.register.model

import com.google.gson.annotations.SerializedName

data class ResponseRegister(

	@field:SerializedName("data")
	val data: List<Any?>? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("isSuccess")
	val isSuccess: Boolean? = null
)
