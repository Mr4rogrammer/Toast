package com.mrprogrammer.Utils.CommonFunctions

import android.content.Context
import androidx.core.content.edit

class LocalSharedPreferences {

    companion object{
        fun saveAppTourState(context:Context,state:Boolean){
            val sharedPref = context.getSharedPreferences("AppTour", Context.MODE_PRIVATE)
            sharedPref.edit {
                putBoolean("state", state)
                apply()
            }
        }

        fun getAppTourState(context: Context):Boolean{
            val sharedPref = context.getSharedPreferences("AppTour", Context.MODE_PRIVATE)
            return sharedPref.getBoolean("state", false)
        }

        fun saveUserLocally(context: Context, name: String?, email: String?, imageUrl: String?) {
            val sharedPreferences = context.getSharedPreferences("MrLocalDb", Context.MODE_PRIVATE)
            val localDb = sharedPreferences.edit()
            localDb.putString("LocalDbNameValueName", name)
            localDb.putString("LocalDbNameValueEmail", email)
            localDb.putString("LocalDbNameValueImage", imageUrl)
            localDb.apply()
        }

        fun getLocalSavedUser(context: Context): List<String?>? {
            val LocalUserData = ArrayList<String?>()
            val sharedPreferences =
                context.getSharedPreferences("MrLocalDb", Context.MODE_PRIVATE)
            val name = sharedPreferences.getString("LocalDbNameValueName", "")
            val email = sharedPreferences.getString("LocalDbNameValueEmail", "")
            val imageUrl = sharedPreferences.getString("LocalDbNameValueImage", "")
            LocalUserData.add(name)
            LocalUserData.add(email)
            LocalUserData.add(imageUrl)
            return LocalUserData
        }
    }
}