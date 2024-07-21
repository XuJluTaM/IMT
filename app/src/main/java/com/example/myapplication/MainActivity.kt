package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val weightEditText: EditText = findViewById(R.id.weightEditText)
        val heightEditText: EditText = findViewById(R.id.heightEditText)
        val calculateButton: Button = findViewById(R.id.calculateButton)

        calculateButton.setOnClickListener {
            val weight = weightEditText.text.toString().toFloatOrNull()
            val height = heightEditText.text.toString().toFloatOrNull()

            if (weight != null && height != null) {
                val intent = Intent(this, ResultActivity::class.java).apply {
                    putExtra("WEIGHT", weight)
                    putExtra("HEIGHT", height)
                }
                startActivity(intent)
            }
        }
    }
}
