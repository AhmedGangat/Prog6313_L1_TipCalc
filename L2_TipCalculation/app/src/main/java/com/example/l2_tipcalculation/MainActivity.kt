package com.example.l2_tipcalculation

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // Ensure layout is set correctly

        // Get references to UI elements
        val etBillAmount = findViewById<EditText>(R.id.etBillAmount)
        val etTipPercentage = findViewById<EditText>(R.id.etTipPercentage)
        val btnCalculate = findViewById<Button>(R.id.btnCalculate)
        val tvTipAmount = findViewById<TextView>(R.id.tvTipAmount)

        // Set click listener on the button
        btnCalculate.setOnClickListener {
            calculateTip(etBillAmount, etTipPercentage, tvTipAmount)
        }
    }

    private fun calculateTip(
        etBillAmount: EditText,
        etTipPercentage: EditText,
        tvTipAmount: TextView
    ) {
        val billAmountStr = etBillAmount.text.toString()
        val tipPercentageStr = etTipPercentage.text.toString()

        if (billAmountStr.isNotEmpty() && tipPercentageStr.isNotEmpty()) {
            val billAmount = billAmountStr.toDoubleOrNull()
            val tipPercentage = tipPercentageStr.toDoubleOrNull()

            if (billAmount != null && tipPercentage != null) {
                val tipAmount = (billAmount * tipPercentage) / 100
                tvTipAmount.text = "Tip Amount: $%.2f".format(tipAmount)
            } else {
                tvTipAmount.text = "Please enter valid numbers!"
            }
        } else {
            tvTipAmount.text = "Please fill in all fields!"
        }
    }
}