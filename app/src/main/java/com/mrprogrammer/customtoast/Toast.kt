package com.mrprogrammer.customtoast

import android.app.Activity

fun success(activity: Activity, message: String, duration: Int) {
    HeadToast(activity, message, duration,R.drawable.checked,R.color.success_left,R.color.success)
}



fun warning(activity: Activity, message: String, duration: Int) {
    HeadToast(activity, message, duration,R.drawable.alert,R.color.warning_left,R.color.warning)
}



fun information(activity: Activity, message: String, duration: Int) {
    HeadToast(activity, message, duration, R.drawable.information,R.color.information_left,R.color.information)
}


fun error(activity: Activity, message: String, duration: Int ) {
    HeadToast(activity, message, duration, R.drawable.error,R.color.error_left,R.color.error)
}

fun message(activity: Activity, message: String, duration: Int) {
    HeadToast(activity, message, duration, R.drawable.message,R.color.message_left,R.color.message)
}