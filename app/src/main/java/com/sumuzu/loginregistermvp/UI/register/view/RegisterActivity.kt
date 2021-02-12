package com.sumuzu.loginregistermvp.UI.register.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.sumuzu.loginregistermvp.R
import com.sumuzu.loginregistermvp.UI.login.view.LoginActivity
import com.sumuzu.loginregistermvp.UI.register.model.ResponseRegister
import com.sumuzu.loginregistermvp.UI.register.presenter.RegisterPresenter
import com.sumuzu.loginregistermvp.UI.register.presenter.RegisterView
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity(), RegisterView {

    private var presenter : RegisterPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        presenter = RegisterPresenter(this)

        btnSignUp.setOnClickListener {

            //ambil inputan user
            val nama = etNama.text.toString()
            val email = etEmail.text.toString()
            val password = etPassword.text.toString()
            val passwordConfirm = etPasswordConfirm.text.toString()
            val noHp = etHP.text.toString()

            presenter?.register(nama, email, password, passwordConfirm, noHp)

        }

    }

    override fun successRegister(response: ResponseRegister) {
        startActivity(Intent(this, LoginActivity::class.java))
    }

    override fun errorRegister(msg: String) {
        showToast(msg)
    }

    override fun empty() {
        showToast("tidak boleh ada inputan kosong")
    }

    override fun noMatch() {
        showToast("password tidak cocok")
    }

    override fun startProgressBar() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideProgressBar() {
        progressBar.visibility = View.GONE
    }

    fun showToast(msg : String){
        Toast.makeText(this, "$msg", Toast.LENGTH_LONG).show()
    }
}