package com.example.mainprojectapplication

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mainprojectapplication.databinding.ActivityExercisesBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class ExerciseActivity : AppCompatActivity() {

    private val sharedPreferencesKey = "MySharedPreferences"
    private lateinit var exerciseRecyclerView: RecyclerView
    private lateinit var displayedArrayList: ArrayList<ExerciseData>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercises)

        var exerciseAdd= ExerciseAdd()

        exerciseAdd.addExercises()

        var beginnerExercises = exerciseAdd.beginner
        var intermediateExercises = exerciseAdd.intermediate
        var advancedExercises = exerciseAdd.advanced

        val sharedPreferences = getSharedPreferences(sharedPreferencesKey, Context.MODE_PRIVATE)
        val fitnessLevel = sharedPreferences.getString("Exercise", "None")

        displayFitnessLevel(fitnessLevel)

        exerciseRecyclerView = findViewById(R.id.exerciseRecyclerView)
        exerciseRecyclerView.layoutManager = LinearLayoutManager(this)
        exerciseRecyclerView.setHasFixedSize(true)

        displayedArrayList = when (fitnessLevel) {
            "Beginner" -> beginnerExercises
            "Intermediate" -> intermediateExercises
            "Advanced" -> advancedExercises
            else -> ArrayList()
        }

        getLevelExercises()

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
        val fitnessLevelTextView: TextView = findViewById(R.id.catexercises)

        when (fitnessLevel) {
            "Beginner" -> {
                fitnessLevelTextView.text = "Beginner Exercises"
            }

            "Intermediate" -> {
                fitnessLevelTextView.text = "Intermediate Exercises"
            }

            "Advanced" -> {
                fitnessLevelTextView.text = "Advanced Exercises"
            }

            else -> {
                fitnessLevelTextView.text = "Fitness Level not specified:\nExercises not displayed"
            }
        }
    }

    private fun getLevelExercises(){
        val adapter = ExerciseAdapter(displayedArrayList)
        exerciseRecyclerView.adapter = adapter
    }
}