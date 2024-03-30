package com.example.quizapp

import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.quizapp.databinding.ActivityMainBinding
import com.example.quizapp.ui.QuestionsActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val startButton: Button = findViewById(R.id.button_start)
        val editTextName: EditText = findViewById(R.id.name)

        startButton.setOnClickListener {
            if (editTextName.text.isNotEmpty()) {
                //Go from Main to Questions Activity
                Intent(this@MainActivity, QuestionsActivity::class.java).also {
                    startActivity(it)
                    finish() //Take out the previous activity
                }
            } else {
                Toast.makeText(this@MainActivity, "Please enter your name", Toast.LENGTH_LONG).show()
            }
        }
    }
}