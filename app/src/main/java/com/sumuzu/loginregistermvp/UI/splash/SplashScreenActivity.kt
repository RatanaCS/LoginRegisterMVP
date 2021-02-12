package com.sumuzu.loginregistermvp.UI.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.sumuzu.loginregistermvp.MainActivity
import com.sumuzu.loginregistermvp.R
import com.sumuzu.loginregistermvp.UI.login.view.LoginActivity
import com.sumuzu.loginregistermvp.helper.SessionManager

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val session = SessionManager(this)

        Handler().postDelayed({
            if(session.login ?: true){
                startActivity(Intent(this, MainActivity::class.java))
            }else{
                startActivity(Intent(this, LoginActivity::class.java))
            }
            finish()
        }, 3000)

    }
}