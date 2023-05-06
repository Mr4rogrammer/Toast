package com.mrprogrammer.Utils.Toast

import android.app.Activity
import android.widget.*
import androidx.core.content.ContextCompat
import com.mrprogrammer.Utils.R


/**
 * Mr.Programmer
 * Passing duration as 0 for Short
 * Passing duration as -1 for LONG
 * also can use Toast.LENGTH_ *
 * **/
class MrToast {
    fun success(activity: Activity, message: String, duration: Int = 0) {
        HeadToast(activity, message, duration, R.drawable.checked,R.color.success_left,R.color.success)
    }

    fun warning(activity: Activity, message: String, duration: Int = 0) {
        HeadToast(activity, message, duration,R.drawable.alert,R.color.warning_left,R.color.warning)
    }


    fun information(activity: Activity, message: String, duration: Int = 0) {
        HeadToast(activity, message, duration, R.drawable.information,R.color.information_left,R.color.information)
    }


    fun error(activity: Activity, message: String, duration: Int = 0 ) {
        HeadToast(activity, message, duration, R.drawable.error,R.color.error_left,R.color.error)
    }

    fun message(activity: Activity, message: String, duration: Int = 0) {
        HeadToast(activity, message, duration, R.drawable.message,R.color.message_left,R.color.message)
    }

    private fun HeadToast(
        activity: Activity, message: String, duration: Int,
        icon: Int,
        bordercolor:Int,
        background_bg:Int) {

        val toast = Toast(activity);
        val layout = activity.layoutInflater.inflate(
            R.layout.main_toast_success,
            activity.findViewById(R.id.toast_container)
        )
        val textView = layout.findViewById<TextView>(R.id.toast_text)
        textView.text = message
        val images=layout.findViewById<ImageView>(R.id.image);
        val frame = layout.findViewById<FrameLayout>(R.id.button_accent_border);
        val background =layout.findViewById<RelativeLayout>(R.id.button_click_parent);
        images.setImageDrawable(ContextCompat.getDrawable(activity, icon))

        frame.setBackgroundColor(ContextCompat.getColor(activity, bordercolor))
        background.setBackgroundColor(ContextCompat.getColor(activity, background_bg))

        toast.apply {
            toast.duration = duration
            view = layout
            show()
        }
    }
}

