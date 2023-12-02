package com.example.mainprojectapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.google.android.material.bottomnavigation.BottomNavigationView

class MealPlanActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mealplan)

        val bottomNavigationView: BottomNavigationView = findViewById(R.id.mealBottomNavigationView)
        val mealCard1: CardView = findViewById(R.id.mealCard1)
        val mealCard2: CardView = findViewById(R.id.mealCard2)
        val createMealButton: Button = findViewById(R.id.createmeal)

        mealCard1.setOnClickListener {
            openMealListFragment()
        }

        mealCard2.setOnClickListener {
            openMealListFragment()
        }

        createMealButton.setOnClickListener {
            // Start the CreateMealActivity when the button is clicked
            val intent = Intent(this, CreateMealActivity::class.java)
            startActivity(intent)
        }

        // Set up item selection listener
        bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.menu_profile -> {
                    val intent = Intent(this, ProfileActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.menu_exercise -> {
                    val intent = Intent(this, ExerciseActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.menu_meal -> {
                    val intent = Intent(this, MealPlanActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.menu_workout -> {
                    val intent = Intent(this, WorkoutActivity::class.java)
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }
    }

    private fun openMealListFragment() {
        // Open MealListFragment when a card is clicked
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, MealListFragment())
            .addToBackStack(null) // Optional: add to back stack if you want to navigate back
            .commit()
    }
}

