package com.example.first_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var firstNumber: EditText
    private lateinit var secondNumber: EditText
    private lateinit var add: Button
    private lateinit var multiply: Button
    private lateinit var sol: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        firstNumber = findViewById(R.id.editTextNumber)
        secondNumber = findViewById(R.id.editTextNumber2)
        add = findViewById(R.id.button)
        multiply = findViewById(R.id.button2)
        sol = findViewById(R.id.textView)

        add.setOnClickListener {
            calculateAndDisplayResult(true)
        }

        multiply.setOnClickListener {
            calculateAndDisplayResult(false)
        }
    }

    private fun calculateAndDisplayResult(doAddition: Boolean) {
        val num1Str = firstNumber.text.toString()
        val num2Str = secondNumber.text.toString()

        if (num1Str.isNotEmpty() && num2Str.isNotEmpty()) {
            val num1 = num1Str.toInt()
            val num2 = num2Str.toInt()

            val result = if (doAddition) {
                num1 + num2
            } else {
                num1 * num2
            }

            sol.text = "Result: $result"
        } else {
            sol.text = "Please enter two numbers"
        }
    }
}
