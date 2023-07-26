package com.mrprogrammer.Utils.CommonFunctions

import android.content.Context
import androidx.core.content.edit

class LocalSharedPreferences {

    companion object{
        fun savePreferences(context:Context,key:String,state:String){
            val sharedPref = context.getSharedPreferences("MrLocalDb", Context.MODE_PRIVATE)
            sharedPref.edit {
                putString(key, state)
                apply()
            }
        }

        fun getPreferences(context: Context,key: String):String{
            val sharedPref = context.getSharedPreferences("MrLocalDb", Context.MODE_PRIVATE)
            return sharedPref.getString(key,"").toString()
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

        fun isAppReviewed(context: Context): Boolean {
            val sharedPreferences = context.getSharedPreferences("MrLocalDb", Context.MODE_PRIVATE)
            return sharedPreferences.getBoolean("isReviewed", false)
        }

        fun setAppReviewed(context: Context) {
            val sharedPreferences = context.getSharedPreferences("MrLocalDb", Context.MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.putBoolean("isReviewed", true)
            editor.apply()
        }
    }
}