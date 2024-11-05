package com.example.rubricaapp

import android.content.Intent
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
        var contactsList = contacts.keys.toList()

        val contactsListView = findViewById<ListView>(R.id.list)
        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, contactsList)
        contactsListView.adapter = arrayAdapter

        contactsListView.setOnItemClickListener { parent, _, position, _ ->
            Log.d("contact_selected", contactsList[position])
            val selectedContactName = contactsList[position]
            val selectedContact = contacts[selectedContactName]

            val it = Intent(applicationContext, ContactActivity::class.java)
            it.putExtra("name", selectedContact?.name)
            it.putExtra("surname", selectedContact?.surname)
            it.putExtra("age", selectedContact?.age)
            startActivity(it)

        }
    }

}
