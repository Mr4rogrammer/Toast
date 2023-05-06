package com.rjtech.shop.Utils

import android.annotation.SuppressLint
import android.app.Activity
import android.app.ActivityManager
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*

class CommonFunctions {
    companion object {
        fun FirebaseClearString(aString: String?): String? {
            var aString = aString
            aString = aString?.replace("@", "")
            aString = aString?.replace(".", "")
            aString = aString?.replace("#", "")
            aString = aString?.replace("$", "")
            aString = aString?.replace("[", "")
            aString = aString?.replace("]", "")
            return aString
        }

        fun getDate(): String? {
            val date = Date()
            val formatter = SimpleDateFormat("dd/MM/yy")
            return formatter.format(date)
        }

        fun getTime(): String? {
            val date = Date()
            val formatter = SimpleDateFormat("hh-mm-ss")
            return formatter.format(date)
        }

        fun createUniqueKey(): String? {
            val date = Date()
            val uuiValue = UUID.randomUUID().toString().replace("-", "")
            val formatter = SimpleDateFormat("yyyyMMddHHmmssS")
            return formatter.format(date) + uuiValue
        }


        fun getYYYYMM(): String? {
            val date = Date()
            val formatter = SimpleDateFormat("yyyyMM")
            return formatter.format(date)
        }

        @SuppressLint("MissingPermission")
        fun isConnected(context: Context): Boolean {
            val connectivityManager =
                context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            if (connectivityManager != null) {
                val info = connectivityManager.allNetworkInfo
                if (info != null) {
                    for (networkInfo in info) {
                        if (networkInfo.state == NetworkInfo.State.CONNECTED) {
                            return true
                        }
                    }
                }
            }
            return false
        }

        fun logout(context: Context) {
            (context.getSystemService(AppCompatActivity.ACTIVITY_SERVICE) as ActivityManager).clearApplicationUserData()
        }

        fun openInWhatsApp(context: Context, number: String) {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://api.whatsapp.com/send?phone=$number")
            context.startActivity(intent)
        }

    }
}