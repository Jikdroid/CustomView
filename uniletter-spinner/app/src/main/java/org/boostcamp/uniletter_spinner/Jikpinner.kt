package org.boostcamp.uniletter_spinner

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView

class Jikpinner @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {
    private lateinit var items: Array<CharSequence>

    private lateinit var title: TextView
    private lateinit var recyclerView: RecyclerView

    init {
        setAttrs(attrs)
        setView()
        setVisibility()

        recyclerView.addOnLayoutChangeListener { v, left, top, right, bottom, oldLeft, oldTop, oldRight, oldBottom ->
            title.width = right - left
        }
    }

    private fun setAttrs(attrs: AttributeSet?) {
        context.obtainStyledAttributes(attrs, R.styleable.Jikpinner).run {
            items = getTextArray(R.styleable.Jikpinner_items) ?: arrayOf("전체", "간식나눔", "공고")
            recycle()
        }
    }

    private fun setView() {
        inflate(context, R.layout.jikpinner, this@Jikpinner)
        recyclerView = findViewById<RecyclerView>(R.id.rv_menu).apply {
            adapter = JikpinnerAdapter(items)
        }
        title = findViewById<TextView>(R.id.title).apply {
            text = items.first()
        }
    }

    private fun setVisibility() {
        title.setOnClickListener {

        }
    }
}