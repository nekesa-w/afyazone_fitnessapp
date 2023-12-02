package com.example.mainprojectapplication

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mainprojectapplication.databinding.ActivityExercisesBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class ExerciseActivity : AppCompatActivity() {

    private lateinit var exerciseManager: ExerciseManager
    private lateinit var exerciseContainer: LinearLayout
    private lateinit var binding : ActivityExercisesBinding
    private lateinit var exerciseRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercises)

        exerciseManager = ExerciseManager(this)
        exerciseManager.initializeExercises()

        val sharedPreferences = getSharedPreferences("MySharedPreferences", MODE_PRIVATE)
        val fitnessLevel = sharedPreferences.getString("Exercise", "None")
        val categoryExercises = exerciseManager.getExercises(fitnessLevel)

        displayFitnessLevel(fitnessLevel)

        exerciseContainer = findViewById(R.id.exerciseRecyclerView)

        val adapter = ExerciseAdapter(categoryExercises)
        exerciseRecyclerView.layoutManager = LinearLayoutManager(this)
        exerciseRecyclerView.adapter = adapter

        val bottomNavigationView: BottomNavigationView = findViewById(R.id.exercisesBottomNavigationView)

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

    private fun displayFitnessLevel(fitnessLevel: String?) {
        val fitnessLevelTextView: TextView = binding.catexercises

        when (fitnessLevel) {
            "Beginner" -> {
                fitnessLevelTextView.text = "Exercises based on your fitness level: Beginner Exercises"
            }

            "Intermediate" -> {
                fitnessLevelTextView.text = "Exercises based on your fitness level: Intermediate Exercises"
            }

            "Advanced" -> {
                fitnessLevelTextView.text = "Exercises based on your fitness level: Advanced Exercises"
            }

            else -> {
                fitnessLevelTextView.text = "Fitness Level Not Specified"
            }
        }
    }
}