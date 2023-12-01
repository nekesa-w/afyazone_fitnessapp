package com.example.mainprojectapplication

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.mainprojectapplication.databinding.ActivityExercisesBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class ExerciseActivity : AppCompatActivity() {

    private lateinit var exerciseManager: ExerciseManager
    private lateinit var exerciseContainer: LinearLayout
    private lateinit var binding : ActivityExercisesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercises)

        exerciseManager = ExerciseManager(this)
        exerciseManager.initializeExercises()

        val sharedPreferences = getSharedPreferences("MySharedPreferences", MODE_PRIVATE)
        val fitnessLevel = sharedPreferences.getString("Exercise", "None")
        val categoryExercises = exerciseManager.getExercises(fitnessLevel)

        displayFitnessLevel(fitnessLevel)

        exerciseContainer = findViewById(R.id.exerciseContainer)

        val selectedCategory = getSharedPreferences("ExercisePreferences", MODE_PRIVATE)
            .getString("exercises", "beginner")

        val exercises = ExerciseManager(this).getExercises(selectedCategory)

        for (exercise in exercises) {
            addExerciseItem(exercise)
        }

        val bottomNavigationView: BottomNavigationView = findViewById(R.id.BottomNavigationView)

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
                fitnessLevelTextView.text = "Exercises based on your fitness level: Beginner"
            }

            "Intermediate" -> {
                fitnessLevelTextView.text = "Exercises based on your fitness level: Intermediate"
            }

            "Advanced" -> {
                fitnessLevelTextView.text = "Exercises based on your fitness level: Advanced"
            }

            else -> {
                fitnessLevelTextView.text = "Fitness Level Not Specified"
            }
        }
    }

    private fun addExerciseItem(exercise: ExerciseData) {
        val exerciseItemView = layoutInflater.inflate(R.layout.item_exercise, exerciseContainer, false)

        val titleTextView: TextView = exerciseItemView.findViewById(R.id.titleTextView)
        val instructionTextView: TextView = exerciseItemView.findViewById(R.id.instructionTextView)
        val imageView: ImageView = exerciseItemView.findViewById(R.id.exerciseImageView)

        titleTextView.text = exercise.name
        instructionTextView.text = exercise.instruction
        imageView.setImageResource(resources.getIdentifier(exercise.imagePath, null, packageName))

        Glide.with(this)
            .load(resources.getIdentifier(exercise.imagePath, null, packageName))
            .into(imageView)

        exerciseContainer.addView(exerciseItemView)
    }

}