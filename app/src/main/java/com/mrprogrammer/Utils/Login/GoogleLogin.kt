package com.mrprogrammer.Utils.Login

import android.app.Activity
import android.content.Context
import android.content.Intent
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.mrprogrammer.Utils.Interface.LoginCompleteHandler
import com.mrprogrammer.Utils.CommonFunctions.CommonFunctions
import java.util.*


class GoogleLogin(val context:Context, val mAuth:FirebaseAuth, val  default_web_client_id: String) {
    private var mGoogleSignClient: GoogleSignInClient? = null
    private val RC_SIGN_IN = 123
    private var reference: DatabaseReference? = null
    private lateinit var handler: LoginCompleteHandler

    init {
        createRequest()
    }

    fun LoginSafely(handler: LoginCompleteHandler){
        this.handler = handler
        val sign = mGoogleSignClient!!.signInIntent
        (context as Activity).startActivityForResult(sign, RC_SIGN_IN)
    }

    fun postActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == RC_SIGN_IN) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                val account = task.getResult(ApiException::class.java)
                firebaseAuthWithGoogle(account)
            } catch (e: ApiException) {
                handler.onFailure(e.message.toString())
            }
        }
    }

    private fun firebaseAuthWithGoogle(account: GoogleSignInAccount) {
        val credential = GoogleAuthProvider.getCredential(account.idToken, null)
        mAuth.signInWithCredential(credential).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val user = mAuth.currentUser
                val clearedEmailString: String? = CommonFunctions.firebaseClearString(user!!.email)
                reference = FirebaseDatabase.getInstance().getReference("Userdata")
                try {
                    if (clearedEmailString != null) {
                        reference?.child(clearedEmailString)?.child("Username")
                            ?.setValue(user.displayName)
                        reference?.child(clearedEmailString)?.child("Email")?.setValue(user.email)
                        reference?.child(clearedEmailString)?.child("Imageurl")?.setValue((user.photoUrl).toString())
                    }
                    handler.onSuccess(user)
                } catch (e: Exception) {
                    handler.onFailure(e.message.toString())
                }
            } else {
                handler.onFailure(task.exception?.message.toString())
            }
        }
    }

    private fun createRequest() {
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(default_web_client_id)
            .requestEmail()
            .build()
        mGoogleSignClient = GoogleSignIn.getClient(context, gso)
    }
}