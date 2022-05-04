package org.inu.customview

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout

class CustomView@JvmOverloads
constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr:Int = 0) : ConstraintLayout(context, attrs,defStyleAttr){
    private val binding = View.inflate(context, R.layout.layout_customview, this)

    init {
        val a = context.obtainStyledAttributes(attrs,R.styleable.customViewData)
        val titleText = a.getString(R.styleable.customViewData_itemTitleText) ?: "Default"
        val titleTextColor = a.getColor(R.styleable.customViewData_itemTitleTextColor, 0xFF1DE9B6.toInt())
        val contentText = a.getString(R.styleable.customViewData_itemContentText) ?: "Default"
        val contentTextColor = a.getColor(R.styleable.customViewData_itemContentTextColor, 0xFFFF0000.toInt())
        a.recycle()

        binding.findViewById<TextView>(R.id.title).text = titleText
        binding.findViewById<TextView>(R.id.title).setTextColor(titleTextColor)
        binding.findViewById<TextView>(R.id.content).text = contentText
        binding.findViewById<TextView>(R.id.content).setTextColor(contentTextColor)
    }
}