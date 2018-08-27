package com.example.shin.go4lunch.ui.login

import android.app.Activity
import android.content.Context

interface LoginContract {

    interface View{
         fun loginWithGoogle()
        fun loginWhitFacebook()
    }

    interface Presenter{
        fun setConnectedGoogle(activity: Activity)
        fun setConnectedFacebook(activity: Activity)
        fun isLoged(activity: Activity)
            }
}