package com.example.rubricaapp

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ContactActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_contact)

        val name = intent.getStringExtra("name")
        val surname = intent.getStringExtra("surname")
        val age = intent.getIntExtra("age", 0)
        val photo = intent.getIntExtra("photo", -1)

        if (photo != -1) {
            val imageView: ImageView = findViewById(R.id.photo)
            imageView.setImageResource(photo)
        }
        val nameTextView: TextView = findViewById(R.id.name)
        nameTextView.text = name
        val surnameTextView: TextView = findViewById(R.id.surname)
        surnameTextView.text = surname
        val ageTextView: TextView = findViewById(R.id.age)
        ageTextView.text = "$age"
    }
}