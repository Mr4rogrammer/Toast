package com.mrprogrammer.customtoast

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var test=findViewById<Button>(R.id.test);



        test.setOnClickListener {

            message(this,"Tets",Toast.LENGTH_LONG,Gravity.CENTER)
        }

    }


}
