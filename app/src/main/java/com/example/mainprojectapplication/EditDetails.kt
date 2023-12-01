package com.example.mainprojectapplication

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.NumberPicker
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.mainprojectapplication.databinding.ActivityEditDetailsBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class EditDetails : AppCompatActivity() {

    private lateinit var binding : ActivityEditDetailsBinding
    private val sharedPreferencesKey = "MySharedPreferences"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPreferences = getSharedPreferences(sharedPreferencesKey, Context.MODE_PRIVATE)
        val username = sharedPreferences.getString("Username", "")

        val weightPicker: NumberPicker = findViewById(R.id.editrectangle1)
        val goalWeightPicker: NumberPicker = findViewById(R.id.editrectangle4)
        val heightPicker: NumberPicker = findViewById(R.id.editrectangle2)
        val agePicker: NumberPicker = findViewById(R.id.editrectangle3)
        val radioGroupGoal: RadioGroup = findViewById(R.id.editradioGroupGoal)
        val radioGroupExercise: RadioGroup = findViewById(R.id.editradioGroupExercise)
        val frequencyPicker: NumberPicker = findViewById(R.id.editrectangle5)

        // Set min and max values for NumberPickers
        weightPicker.minValue = 30
        weightPicker.maxValue = 300

        goalWeightPicker.minValue = 30
        goalWeightPicker.maxValue = 200

        heightPicker.minValue = 50
        heightPicker.maxValue = 270

        agePicker.minValue = 18
        agePicker.maxValue = 120

        frequencyPicker.minValue = 1
        frequencyPicker.maxValue = 7

        val confirmEditButton: Button = findViewById(R.id.confirmEditButton)

        confirmEditButton.setOnClickListener {
            val selectedGender = getSelectedGender()
            val selectedGoal = getSelectedRadioText(radioGroupGoal)
            val selectedExercise = getSelectedRadioText(radioGroupExercise)

            saveDataToSharedPreferences(
                weightPicker.value,
                goalWeightPicker.value,
                heightPicker.value,
                agePicker.value,
                selectedGender,
                selectedGoal,
                selectedExercise,
                frequencyPicker.value,
                username
            )
            startActivity(Intent(this@EditDetails,ProfileActivity::class.java))
            finish()
        }

        val bottomNavigationView: BottomNavigationView = findViewById(R.id.editBottomNavigationView)

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

    private fun saveDataToSharedPreferences(
        weight: Int,
        goalWeight: Int,
        height: Int,
        age: Int,
        gender: String,
        goal: String,
        exercise: String,
        frequency: Int,
        username: String?
    ) {
        val sharedPreferences = getSharedPreferences(sharedPreferencesKey, Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()

        editor.putInt("Weight", weight)
        editor.putInt("GoalWeight", goalWeight)
        editor.putInt("Height", height)
        editor.putInt("Age", age)
        editor.putString("Gender", gender)
        editor.putString("Goal", goal)
        editor.putString("Exercise", exercise)
        editor.putInt("Frequency", frequency)
        editor.putString("Username", username)

        editor.apply()
    }

    private fun getSelectedRadioText(radioGroup: RadioGroup): String {
        val selectedRadioButtonId = radioGroup.checkedRadioButtonId
        val selectedRadioButton = findViewById<RadioButton>(selectedRadioButtonId)
        return selectedRadioButton.text.toString()
    }

    private fun getSelectedGender(): String {
        val genderRadioGroup: RadioGroup = findViewById(R.id.editradioGroupGender)

        return when (genderRadioGroup.checkedRadioButtonId) {
            R.id.editradioButtonMale -> "Male"
            R.id.editradioButtonFemale -> "Female"
            else -> "" // Handle other cases as needed
        }
    }
}
