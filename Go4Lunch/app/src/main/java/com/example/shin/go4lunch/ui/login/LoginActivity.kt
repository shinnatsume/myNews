package com.example.shin.go4lunch.ui.login

import android.app.Activity
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.shin.go4lunch.R
import kotlinx.android.synthetic.main.activity_login.*


class LoginActivity : AppCompatActivity(), LoginContract.View {


    val loginPresenter = LoginPresenter()

    lateinit var activity :Activity



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        activity= this

          google_btn_connection.setOnClickListener(View.OnClickListener {
            loginWithGoogle()

        })

        facebook_btn_connection.setOnClickListener(View.OnClickListener {
            loginWhitFacebook()

        })


    }



    override fun loginWithGoogle() {
        loginPresenter.setConnectedGoogle(activity)
    }

    override fun loginWhitFacebook() {
        loginPresenter.setConnectedFacebook(activity)
    }


}
