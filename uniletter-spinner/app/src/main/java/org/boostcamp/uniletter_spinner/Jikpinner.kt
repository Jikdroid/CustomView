package org.boostcamp.uniletter_spinner

import android.content.Context
import android.util.AttributeSet
import android.widget.ArrayAdapter
import android.widget.FrameLayout
import android.widget.ListPopupWindow
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout

class Jikpinner @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private lateinit var items: Array<CharSequence>
    private val popUp = ListPopupWindow(context)

    init {
        inflate(context, R.layout.jikpinner, this@Jikpinner)


        setAttrs(attrs)
        setAdapter()
        setView()
        setPopup()
        popUp.setContentWidth(measureWidth() + 100)
        findViewById<TextView>(R.id.tv_title).width = popUp.width
    }

    private fun setAttrs(attrs: AttributeSet?) {
        context.obtainStyledAttributes(attrs, R.styleable.Jikpinner).run {
            items = getTextArray(R.styleable.Jikpinner_items) ?: arrayOf("전체", "간식나눔", "공고")
            recycle()
        }
    }


    private fun setAdapter() {
        popUp.setAdapter(ArrayAdapter(context, R.layout.item_jikpinner, items))
    }

    private fun measureWidth(): Int {
        var width = 0
        for (i in items.indices) {
            val view = ArrayAdapter(context, R.layout.item_jikpinner, items).getView(
                i,
                null,
                FrameLayout(context)
            )
            view.measure(0, 0)
            width = width.coerceAtLeast(view.measuredWidth)
        }
        return width
    }

    private fun setView() {
        findViewById<TextView>(R.id.tv_title).apply {
            text = items.first()
            setOnClickListener {
                if (popUp.isShowing) {
                    popUp.dismiss()
                } else {
                    popUp.show()
                }
            }
        }
    }

    private fun setPopup() {

        popUp.isModal = true
        popUp.anchorView = this
        popUp.verticalOffset = this.height + 8
        setOnItemClickListener()
    }

    private fun setOnItemClickListener() {
        popUp.setOnItemClickListener { _, _, position, _ ->
            findViewById<TextView>(R.id.tv_title).text = items[position]
            popUp.dismiss()
        }
    }
}