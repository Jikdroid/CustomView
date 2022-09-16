package org.inu.customview

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.appcompat.widget.AppCompatButton
import androidx.constraintlayout.widget.ConstraintLayout

class TestCustomView @JvmOverloads
constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
    ConstraintLayout(context, attrs, defStyleAttr) {
        private val view = View.inflate(context,R.layout.layout_test_custom_view,this)

    init{
        val a = context.obtainStyledAttributes(attrs,R.styleable.TestCustomView)
        val customBackgroundTint = a.getColor(R.styleable.TestCustomView_backgroundTint, 0xFF018786.toInt())
        val customText = a.getString(R.styleable.TestCustomView_testText) ?: "Default"
        val customTextSize = a.getInteger(R.styleable.TestCustomView_testTextSize, 24)

        a.recycle()



        view.findViewById<AppCompatButton>(R.id.testCustomButton1).apply {
            background.setTint(customBackgroundTint)
            text = customText
            textSize = customTextSize.toFloat()
        }
        view.findViewById<AppCompatButton>(R.id.testCustomButton2).apply {
            background.setTint(0xFFFFFFFF.toInt())
            text = customText
            textSize = customTextSize.toFloat()
        }
    }
}