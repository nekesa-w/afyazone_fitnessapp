package com.example.mainprojectapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class DetailsActivity : AppCompatActivity() {

    private lateinit var database: FirebaseDatabase
    private lateinit var databaseReference: DatabaseReference

    // Declare your UI elements here
    private lateinit var weightEditText: EditText
    private lateinit var heightEditText: EditText
    private lateinit var ageEditText: EditText
    private lateinit var genderRadioButtonMale: RadioButton
    private lateinit var genderRadioButtonFemale: RadioButton
    private lateinit var nextButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        // Initialize Firebase
        database = FirebaseDatabase.getInstance()
        databaseReference = database.reference

        // Initialize your UI elements
        weightEditText = findViewById(R.id.weight)
        heightEditText = findViewById(R.id.height)
        ageEditText = findViewById(R.id.age)
        genderRadioButtonMale = findViewById(R.id.radioButtonMale)
        genderRadioButtonFemale = findViewById(R.id.radioButtonFemale)
        nextButton = findViewById(R.id.nextButton)

        // Add a click listener to the Next button
        nextButton.setOnClickListener {
            // Get the values from the UI elements
            val weight = weightEditText.text.toString()
            val height = heightEditText.text.toString()
            val age = ageEditText.text.toString()
            val gender = if (genderRadioButtonMale.isChecked) "Male" else "Female"

            // Save the information to Firebase
            saveToFirebase(weight, height, age, gender)
        }
    }

    private fun saveToFirebase(weight: String, height: String, age: String, gender: String) {
        // Create a unique key for each entry
        val entryKey = databaseReference.child("userEntries").push().key

        // Create a map with the information
        val entryValues = hashMapOf(
            "weight" to weight,
            "height" to height,
            "age" to age,
            "gender" to gender
        )

        // Save the information to Firebase under the unique key
        if (entryKey != null) {
            databaseReference.child("userEntries").child(entryKey).setValue(entryValues)
        }
    }
}
