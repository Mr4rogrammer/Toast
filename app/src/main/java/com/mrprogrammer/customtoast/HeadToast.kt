package com.mrprogrammer.customtoast

import android.app.Activity
import android.widget.*
import androidx.core.content.ContextCompat

fun HeadToast(
    activity: Activity, message: String, duration: Int, gravity: Int,
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
        setGravity(gravity, 0, 0)
        toast.duration = duration
        view = layout
        show()
    }
}