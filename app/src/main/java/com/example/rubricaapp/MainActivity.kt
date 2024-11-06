package com.example.rubricaapp

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.time.LocalDate
import java.time.Period

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val contacts: MutableMap<String, Contact> = mutableMapOf()
        contacts["Luca"] = Contact(name = "Luca", surname = "Binotti", age = Period.between(LocalDate.of(2003, 5, 29), LocalDate.now()).years, photo = R.drawable.luca)
        contacts["John"] = Contact(name = "John", surname = "Doe", age = 30, photo = R.drawable.john)
        contacts["Jane"] = Contact(name = "Jane", surname = "Smith", age = 25, photo = R.drawable.jane)

        val contactsList = contacts.keys.toList()

        val contactsListView = findViewById<ListView>(R.id.list)
        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, contactsList)
        contactsListView.adapter = arrayAdapter

        contactsListView.setOnItemClickListener { parent, _, position, _ ->

            val selectedContactName = contactsList[position]
            val selectedContact = contacts[selectedContactName]

            if (selectedContact != null)
            {
                if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
                    val imageView: ImageView = findViewById(R.id.photo)
                    imageView.setImageResource(selectedContact.photo)
                    val nameTextView: TextView = findViewById(R.id.name)
                    nameTextView.text = selectedContact.name
                    val surnameTextView: TextView = findViewById(R.id.surname)
                    surnameTextView.text = selectedContact.surname
                    val ageTextView: TextView = findViewById(R.id.age)
                    ageTextView.text = "${selectedContact.age}"
                }
                else {
                    val it = Intent(applicationContext, ContactActivity::class.java)
                    it.putExtra("name", selectedContact.name)
                    it.putExtra("surname", selectedContact.surname)
                    it.putExtra("age", selectedContact.age)
                    it.putExtra("photo", selectedContact.photo)
                    startActivity(it)
                }
            }
        }
    }
}
