package com.example.myapplication

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val textViewBMI: TextView = findViewById(R.id.textViewBMI)
        val imageViewBMI: ImageView = findViewById(R.id.imageViewBMI)
        val textViewRecommendations: TextView = findViewById(R.id.textViewRecommendations)

        val weight = intent.getFloatExtra("WEIGHT", 0.0f)
        val height = intent.getFloatExtra("HEIGHT", 0.0f)

        if (weight > 0 && height > 0) {
            val bmi = weight / ((height / 100) * (height / 100)) // height in meters
            textViewBMI.text = "BMI: %.2f".format(bmi)

            // Display appropriate image and recommendations
            when {
                bmi < 18.5 -> {
                    imageViewBMI.setImageResource(R.drawable.underweight)
                    textViewRecommendations.text = "Underweight: Eat more nutritious food and maintain a balanced diet."
                }
                bmi in 18.5..24.9 -> {
                    imageViewBMI.setImageResource(R.drawable.normal)
                    textViewRecommendations.text = "Normal weight: Maintain a balanced diet and regular exercise."
                }
                else -> {
                    imageViewBMI.setImageResource(R.drawable.overweight)
                    textViewRecommendations.text = "Overweight: Consider a healthier diet and more physical activity."
                }
            }
        } else {
            textViewBMI.text = "Invalid input."
        }
    }
}
