package com.example.mainprojectapplication

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class WorkoutActivity : AppCompatActivity() {

    private val sharedPreferencesKey = "MySharedPreferences"
    private lateinit var displayedWorkoutList: ArrayList<ExerciseData>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_workout)

        var exerciseAddWorkout= ExerciseAdd()

        exerciseAddWorkout.addExercises()

        var beginnerWorkout = exerciseAddWorkout.beginner
        var intermediateWorkout = exerciseAddWorkout.intermediate
        var advancedWorkout = exerciseAddWorkout.advanced

        val sharedPreferences = getSharedPreferences(sharedPreferencesKey, Context.MODE_PRIVATE)
        val workoutLevel = sharedPreferences.getString("Exercise", "None")

        displayWorkoutLevel(workoutLevel)

        displayedWorkoutList = when (workoutLevel) {
            "Beginner" -> beginnerWorkout
            "Intermediate" -> intermediateWorkout
            "Advanced" -> advancedWorkout
            else -> ArrayList()
        }

        displayWorkoutData()

        val bottomNavigationView: BottomNavigationView = findViewById(R.id.workoutBottomNavigationView)

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

    private fun displayWorkoutLevel(workoutLevel: String?) {
        val workoutLevelTextView: TextView = findViewById(R.id.perswork)

        when (workoutLevel) {
            "Beginner" -> {
                workoutLevelTextView.text = "Beginner Workout Routines"
            }

            "Intermediate" -> {
                workoutLevelTextView.text = "Intermediate Workout Routines"
            }

            "Advanced" -> {
                workoutLevelTextView.text = "Advanced Workout Routines"
            }

            else -> {
                workoutLevelTextView.text = "Fitness Level not specified:\nWorkout Routines not displayed"
            }
        }
    }

    private fun displayWorkoutData() {

        val fullExercises = displayedWorkoutList?.filter { it.split == "Full" }
        val upperExercises = displayedWorkoutList?.filter { it.split == "Upper" }
        val lowerExercises = displayedWorkoutList?.filter { it.split == "Lower" }

        val fullText = fullExercises?.joinToString("\n") { exerciseData ->
            exerciseData.name
        }
        val upperText = upperExercises?.joinToString("\n") { exerciseData ->
            exerciseData.name
        }
        val lowerText = lowerExercises?.joinToString("\n") { exerciseData ->
            exerciseData.name
        }

        val fullTextView: TextView = findViewById(R.id.fullWorkout)
        val upperTextView: TextView = findViewById(R.id.upperWorkout)
        val lowerTextView: TextView = findViewById(R.id.lowerWorkout)

        fullTextView.text = "Full Body:\n\n$fullText"
        upperTextView.text = "Upper Body:\n\n$upperText"
        lowerTextView.text = "Lower Body:\n\n$lowerText"
    }

}
