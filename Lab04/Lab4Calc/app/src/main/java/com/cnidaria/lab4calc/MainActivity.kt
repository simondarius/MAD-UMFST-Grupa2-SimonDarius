package com.cnidaria.lab4calc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    private lateinit var textInputNum1: TextInputEditText
    private lateinit var textInputNum2: TextInputEditText
    private lateinit var textViewResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textInputNum1 = findViewById(R.id.textInputNum1)
        textInputNum2 = findViewById(R.id.textInputNum2)
        textViewResult = findViewById(R.id.textViewResult)

        val buttonAdd: Button = findViewById(R.id.buttonAdd)
        val buttonSub: Button = findViewById(R.id.buttonSub)
        val buttonDiv: Button = findViewById(R.id.buttonDiv)
        val buttonMul: Button = findViewById(R.id.buttonMul)

        buttonAdd.setOnClickListener { performOperation("add") }
        buttonSub.setOnClickListener { performOperation("sub") }
        buttonDiv.setOnClickListener { performOperation("div") }
        buttonMul.setOnClickListener { performOperation("mul") }
    }

    private fun performOperation(operation: String) {
        val num1Str = textInputNum1.text.toString()
        val num2Str = textInputNum2.text.toString()

        if (num1Str.isNotEmpty() && num2Str.isNotEmpty()) {
            val num1 = num1Str.toDouble()
            val num2 = num2Str.toDouble()

            val result = when (operation) {
                "add" -> num1 + num2
                "sub" -> num1 - num2
                "div" -> num1 / num2
                "mul" -> num1 * num2
                else -> throw IllegalArgumentException("Invalid operation")
            }

            textViewResult.text = "Result: $result"
        } else {
            textViewResult.text = "Please enter both numbers"
        }
    }
}
