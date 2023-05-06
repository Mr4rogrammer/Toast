package com.mrprogrammer.Utils.Widgets

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.mrprogrammer.customtoast.R

class ProgressButton : RelativeLayout{
    private lateinit var rootView : RelativeLayout
    private lateinit var textView : TextView
    private lateinit var progressBar: ProgressBar
    private lateinit var cardView: CardView
    private var loaderColor = 0

    private var text = ""
    private var isLoading = false


    constructor(context:Context): super(context) {
        initView(context)
    }
    constructor(context:Context,attrs:AttributeSet): super(context, attrs) {
        getDataFromAtts(context,attrs)
        initView(context)
    }
    constructor(context:Context,attrs:AttributeSet, defStyle: Int): super(context, attrs, defStyle) {
        getDataFromAtts(context,attrs)
        initView(context)
    }

    private fun getDataFromAtts(context: Context,attrs: AttributeSet){
      val data = context?.obtainStyledAttributes(attrs,R.styleable.ButtonWithLoader)
        if(data != null){
            text = data.getString(R.styleable.ButtonWithLoader_mrtext).toString()
            loaderColor = data.getColor(R.styleable.ButtonWithLoader_mrloadercolor,context.resources.getColor(R.color.white))
            data.recycle()
        }

    }

    private fun initView(context: Context) {
        layoutParams = LayoutParams(LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT)
        LayoutInflater.from(context).inflate(R.layout.progress_button,this,true)
        rootView = findViewById(R.id.MainLayout)
        textView = findViewById(R.id.text)
        progressBar = findViewById(R.id.loader)
        cardView = findViewById(R.id.login)

        if(text.isNotEmpty()) {
            textView.text = text
        }
        progressBar.indeterminateDrawable.setColorFilter(loaderColor,android.graphics.PorterDuff.Mode.MULTIPLY);
        refreshDrawableState()
    }

    fun setLoaderStatus(show:Boolean){
        if(show) {
            textView.visibility = INVISIBLE
            progressBar.visibility = VISIBLE
        } else {
            textView.visibility = VISIBLE
            progressBar.visibility = GONE
        }
    }
}