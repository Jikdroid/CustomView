package org.inu.customview

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout

class CustomView@JvmOverloads
constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr:Int = 0) : LinearLayout(context, attrs,defStyleAttr){
    private val binding = View.inflate(context, R.layout.layout_customview, this)

    init {
        // Load attributes
        val a = context.obtainStyledAttributes(attrs,R.styleable.MyViewStyleable)
        // customText로 정의한 문자열 혹은 Default 문자열
        val customText = a.getString(R.styleable.MyViewStyleable_android_text) ?: "Default"
        // customTextColor로 정의한 색상 혹은 #FF1DE9B6 컬러
        val customTextColor = a.getColor(R.styleable.MyViewStyleable_android_textColor, 0xFFFFFFFF.toInt())
        // customTextColor로 정의한 색상 혹은 #FFFF0000 컬러
        val customTextColorHint = a.getColor(R.styleable.MyViewStyleable_android_textColorHint, 0xFFFFFFFF.toInt())
        a.recycle()


        binding.findViewById<TextView>(R.id.title1).apply {
            text = customText
            setTextColor(customTextColor)
            setHintTextColor(customTextColorHint)
        }
        binding.findViewById<TextView>(R.id.edit1).apply {
            text = customText
            setTextColor(customTextColor)
            setHintTextColor(customTextColorHint)
        }
        binding.findViewById<TextView>(R.id.edit2).apply {
            setTextColor(customTextColor)
            setHintTextColor(customTextColorHint)
        }
    }
}