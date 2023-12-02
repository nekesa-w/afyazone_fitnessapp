package com.example.mainprojectapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.mainprojectapplication.databinding.ActivityCreateMealBinding

class CreateMealActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_meal)

        // Find the createButton by its ID
        val createButton = findViewById<Button>(R.id.createButton)

        // Set a click listener on the button
        createButton.setOnClickListener {
            // Start MealPlanActivity2 when the button is clicked
            val intent = Intent(this, MealPlanActivity2::class.java)
            startActivity(intent)
        }
    }

}