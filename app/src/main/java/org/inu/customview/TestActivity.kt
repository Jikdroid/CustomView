package org.inu.customview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton

class TestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

        findViewById<TestCustomView>(R.id.testCustom1).findViewById<AppCompatButton>(R.id.testCustomButton1).setOnClickListener {
            Toast.makeText(this, "1-1 버튼 클릭", Toast.LENGTH_SHORT).show()
        }
        findViewById<TestCustomView>(R.id.testCustom2).findViewById<AppCompatButton>(R.id.testCustomButton2).setOnClickListener {
            Toast.makeText(this, "2-2 버튼 클릭", Toast.LENGTH_SHORT).show()
        }
    }
}