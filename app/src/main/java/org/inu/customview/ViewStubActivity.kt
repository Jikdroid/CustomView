package org.inu.customview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewStub
import android.widget.Button
import android.widget.TextView

class ViewStubActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_stub)


        findViewById<Button>(R.id.addBar).setOnClickListener {
            setBar()
        }

    }

    private fun setBar(){
        val stub: ViewStub = findViewById(R.id.stub)
        val inflated = stub.inflate()
        val tvIncludeTopBar: TextView = inflated.findViewById(R.id.tvIncludeTopBar)
        tvIncludeTopBar.text = "ViewStub 상단바"
    }
}