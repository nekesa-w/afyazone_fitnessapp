package com.example.mainprojectapplication

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.mainprojectapplication.databinding.ActivityProfileBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class ProfileActivity : AppCompatActivity() {

    private lateinit var binding : ActivityProfileBinding
    private val sharedPreferencesKey = "MySharedPreferences"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        displayProfileData()

        binding.edityourdetails.setOnClickListener {
            startActivity(Intent(this@ProfileActivity,EditDetails::class.java))
            finish()
        }

        val bottomNavigationView: BottomNavigationView = findViewById(R.id.profileBottomNavigationView)

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

    private fun displayProfileData() {
        val sharedPreferences = getSharedPreferences(sharedPreferencesKey, Context.MODE_PRIVATE)

        val nameTextView: TextView = findViewById(R.id.nameTextView)
        val weightTextView: TextView = findViewById(R.id.weightTextView)
        val heightTextView: TextView = findViewById(R.id.heightTextView)
        val ageTextView: TextView = findViewById(R.id.ageTextView)
        val goalWeightTextView: TextView = findViewById(R.id.goalWeightTextView)
        val genderTextView: TextView = findViewById(R.id.genderTextView)
        val goalTextView: TextView = findViewById(R.id.goalTextView)
        val exerciseTextView: TextView = findViewById(R.id.exerciseTextView)
        val frequencyTextView: TextView = findViewById(R.id.frequencyTextView)

        // Retrieve data from SharedPreferences
        val username = sharedPreferences.getString("Username", "None")
        val weight = sharedPreferences.getString("Weight", "None")
        val height = sharedPreferences.getString("Height", "None")
        val age = sharedPreferences.getString("Age", "None")
        val goalWeight = sharedPreferences.getString("GoalWeight", "None")
        val gender = sharedPreferences.getString("Gender", "None")
        val goal = sharedPreferences.getString("Goal", "None")
        val exercise = sharedPreferences.getString("Exercise", "None")
        val frequency = sharedPreferences.getString("Frequency", "None")

        // Display data in TextViews
        nameTextView.text = "Username: $username"
        weightTextView.text = "Weight: $weight"
        heightTextView.text = "Height: $height"
        ageTextView.text = "Age: $age"
        goalWeightTextView.text = "Goal Weight: $goalWeight"
        genderTextView.text = "Gender: $gender"
        goalTextView.text = "Goal: $goal"
        exerciseTextView.text = "Exercise: $exercise"
        frequencyTextView.text = "Frequency: $frequency"
    }
}
