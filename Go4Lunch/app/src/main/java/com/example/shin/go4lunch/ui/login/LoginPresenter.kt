package com.example.shin.go4lunch.ui.login

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.support.v4.app.ActivityCompat.*
import android.support.v4.content.ContextCompat
import android.widget.Toast
import com.example.shin.go4lunch.ui.firtsactivity.FirtsActivity
import com.firebase.ui.auth.AuthUI
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import java.util.*


class LoginPresenter : LoginContract.Presenter {

    override fun isLoged(activity: Activity) {
        val context = activity.applicationContext
        val intent = Intent(context, FirtsActivity::class.java)
        startActivity(context,intent,null)
        Toast.makeText(context,"iam here",Toast.LENGTH_SHORT).show()
    }

    private val RC_SIGN_IN = 123
    var user: FirebaseUser? =  FirebaseAuth.getInstance().currentUser

    override fun setConnectedFacebook(activity: Activity){
        if (user != null){
            isLoged(activity)
        }else{



            activity.startActivityForResult( AuthUI.getInstance()
                    .createSignInIntentBuilder()
                    .setAvailableProviders( Arrays.asList(AuthUI.IdpConfig.FacebookBuilder().build()))
                    .setIsSmartLockEnabled(false, true)
                    .build(),RC_SIGN_IN)

        }
    }

    override fun setConnectedGoogle(activity: Activity) {
        if (user != null){
            isLoged(activity)
            val context = activity.applicationContext

            Toast.makeText(context,"iam here",Toast.LENGTH_SHORT).show()
        }else{
            activity.startActivityForResult( AuthUI.getInstance()
                    .createSignInIntentBuilder()

                    .setAvailableProviders(Arrays.asList(AuthUI.IdpConfig.GoogleBuilder().build()))
                    .setIsSmartLockEnabled(false, true)
                    .build(),RC_SIGN_IN)





        }
    }



}