package org.inu.customview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class ReUsingLayoutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_re_using_layout)

        setView()

    }
    private fun setView(){
        findViewById<TextView>(R.id.tvIncludeTopBar).apply {
            text = "상단바 변경"
        }

        findViewById<TextView>(R.id.textView).setOnClickListener {
            startActivity(Intent(this,ViewStubActivity::class.java))
        }

        findViewById<Button>(R.id.btnAdd).setOnClickListener{
            Toast.makeText(this, "Add 클릭", Toast.LENGTH_SHORT).show()
        }

        findViewById<Button>(R.id.btnDelete).setOnClickListener{
            Toast.makeText(this, "Delete 클릭", Toast.LENGTH_SHORT).show()
        }
    }
}