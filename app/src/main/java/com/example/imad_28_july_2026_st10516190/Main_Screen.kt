package com.example.imad_28_july_2026_st10516190

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Main_Screen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main_screen)
        
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val itemsInput = findViewById<EditText>(R.id.itemsInput)
        val calculateButton = findViewById<Button>(R.id.calculateButton)
        val totalDisplayTextView = findViewById<TextView>(R.id.totalDisplayTextView)
        val detailsButton = findViewById<Button>(R.id.detailsButton)

        calculateButton.setOnClickListener {
            val inputString = itemsInput.text.toString()
            
            if (inputString.isNotEmpty()) {
                try {
                    // Split the input by comma to get individual item counts
                    val itemsArray = inputString.split(",")
                    var totalItems = 0
                    
                    // Loop through the array to calculate the total
                    for (item in itemsArray) {
                        if (item.trim().isNotEmpty()) {
                            totalItems += item.trim().toInt()
                        }
                    }
                    
                    val resultText = "Total Items: $totalItems"
                    totalDisplayTextView.text = resultText
                } catch (_: NumberFormatException) {
                    Toast.makeText(this, "Please enter valid numbers and separate them using commas", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Please enter item counts first", Toast.LENGTH_SHORT).show()
            }
        }

        detailsButton.setOnClickListener {
            val intent = Intent(this, Detailed_View_Screen::class.java)
            startActivity(intent)
        }
    }
}
