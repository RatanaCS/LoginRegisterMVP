package com.sumuzu.loginregistermvp.UI.login.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.sumuzu.loginregistermvp.MainActivity
import com.sumuzu.loginregistermvp.R
import com.sumuzu.loginregistermvp.UI.login.model.DataItem
import com.sumuzu.loginregistermvp.UI.login.presenter.LoginPresenter
import com.sumuzu.loginregistermvp.UI.login.presenter.LoginView
import com.sumuzu.loginregistermvp.UI.register.view.RegisterActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), LoginView {

    private var presenter : LoginPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        presenter = LoginPresenter(this)

        btnLogin.setOnClickListener {

            val email  = etEmail.text.toString()
            val pass = etPassword.text.toString()
            presenter?.login(email, pass)

        }

        btnRegister.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }


    }

    override fun successLogin(msg: String, user: List<DataItem?>) {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    override fun errorLogin(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }
}