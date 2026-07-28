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

// Data class to store item details
data class PartyItem(
    val name: String,
    val category: String,
    val quantity: String,
    val comments: String
)

class Detailed_View_Screen : AppCompatActivity() {
    
    // List to store all added items
    private val itemList = mutableListOf<PartyItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detailed_view_screen)
        
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val itemNameInput = findViewById<EditText>(R.id.itemNameInput)
        val itemCategoryInput = findViewById<EditText>(R.id.itemCategoryInput)
        val itemQuantityInput = findViewById<EditText>(R.id.itemQuantityInput)
        val itemCommentsInput = findViewById<EditText>(R.id.itemCommentsInput)
        
        val saveItemButton = findViewById<Button>(R.id.saveItemButton)
        val displayItemsButton = findViewById<Button>(R.id.displayItemsButton)
        val itemsListDisplay = findViewById<TextView>(R.id.itemsListDisplay)
        val backButton = findViewById<Button>(R.id.backButton)

        // Logic to add an item to the list
        saveItemButton.setOnClickListener {
            val name = itemNameInput.text.toString()
            val category = itemCategoryInput.text.toString()
            val quantity = itemQuantityInput.text.toString()
            val comments = itemCommentsInput.text.toString()

            if (name.isNotEmpty() && category.isNotEmpty() && quantity.isNotEmpty()) {
                val newItem = PartyItem(name, category, quantity, comments)
                itemList.add(newItem)
                
                // Clear inputs after adding
                itemNameInput.text.clear()
                itemCategoryInput.text.clear()
                itemQuantityInput.text.clear()
                itemCommentsInput.text.clear()
                
                Toast.makeText(this, "Item added successfully!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Please fill in Name, Category, and Quantity", Toast.LENGTH_SHORT).show()
            }
        }

        // Logic to display all items using a LOOP
        displayItemsButton.setOnClickListener {
            if (itemList.isEmpty()) {
                itemsListDisplay.text = "The list is currently empty."
            } else {
                var displayString = "--- All Party Items ---\n\n"
                
                // Using a loop to iterate through the list of items
                for (item in itemList) {
                    displayString += "Name: ${item.name}\n" +
                                     "Category: ${item.category}\n" +
                                     "Quantity: ${item.quantity}\n" +
                                     "Comments: ${item.comments}\n" +
                                     "-----------------------\n"
                }
                
                itemsListDisplay.text = displayString
            }
        }

        // Logic to navigate back to Main_Screen
        backButton.setOnClickListener {
            val intent = Intent(this, Main_Screen::class.java)
            startActivity(intent)
            finish()
        }
    }
}
