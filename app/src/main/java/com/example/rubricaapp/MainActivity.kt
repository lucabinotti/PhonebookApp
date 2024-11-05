package com.example.rubricaapp

import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val contacts: MutableMap<String, Contact> = mutableMapOf()
        contacts["john_doe"] = Contact(name = "John", surname = "Doe", age = 30)
        contacts["jane_smith"] = Contact(name = "Jane", surname = "Smith", age = 25)

        // var selection = findViewById<TextView>(R.id.selection)
        var contactList = contacts.keys.toList()

        val contactListView = findViewById<ListView>(R.id.list)
        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, contactList)
        contactListView.adapter = arrayAdapter

        contactListView.setOnItemClickListener { parent, _, position, _ ->
            Log.d("contact_selected", contactList[position])
            var selectedContact = contactList[position]

        }
    }

}
