package com.example.imad_28_july_2026_st10516190

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        
        // Hold the splash screen for 3 seconds, and then navigate to main screen
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, Main_Screen::class.java))
            finish() // Close the splash screen activity
        }, 3000)
    }
}
