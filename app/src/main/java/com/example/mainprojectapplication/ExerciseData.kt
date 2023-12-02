package com.example.mainprojectapplication

import android.content.Context
import org.json.JSONArray
import org.json.JSONObject

data class ExerciseData(val name: String, val instruction: String, val category: String, val imagePath: String)

class ExerciseManager(private val context: Context) {

    private val sharedPreferences = context.getSharedPreferences("ExercisePreferences", Context.MODE_PRIVATE)

    fun saveExercises(category: String, exercises: List<ExerciseData>) {
        val jsonArray = JSONArray()
        for (exercise in exercises) {
            val jsonObject = JSONObject()
            jsonObject.put("name", exercise.name)
            jsonObject.put("instruction", exercise.instruction)
            jsonObject.put("category", exercise.category)
            jsonObject.put("imagePath", exercise.imagePath)
            jsonArray.put(jsonObject.toString())
        }
        sharedPreferences.edit().putString(category, jsonArray.toString()).apply()
    }

    fun getExercises(category: String?): List<ExerciseData> {
        val exercises = mutableListOf<ExerciseData>()
        val jsonArrayString = sharedPreferences.getString(category, "")
        if (jsonArrayString?.isNotEmpty() == true) {
            val jsonArray = JSONArray(jsonArrayString)
            for (i in 0 until jsonArray.length()) {
                val jsonObject = JSONObject(jsonArray.getString(i))
                val exercise = ExerciseData(
                    jsonObject.getString("name"),
                    jsonObject.getString("instruction"),
                    jsonObject.getString("category"),
                    jsonObject.getString("imagePath")
                )
                exercises.add(exercise)
            }
        }
        return exercises
    }

    fun initializeExercises() {
        val beginnerExercises = listOf(
            ExerciseData(
                "Jumping Jacks",
                "1. Stand with your feet together and arms at your sides.\n" +
                        "2. Jump, landing with your feet shoulder-width apart while bringing your arms overhead.\n" +
                        "3. Jump again, returning to the starting position.",
                "beginner",
                "@drawable/jumpjack"
            ),
            ExerciseData(
                "Bodyweight Squats",
                "1. Stand with your feet shoulder-width apart.\n" +
                        "2. Lower your body by pushing your hips back and bending your knees.\n" +
                        "3. Keep your back straight, chest up, and knees aligned with your toes.\n" +
                        "4. Return to the starting position by pushing through your heels.",
                "beginner",
                "@drawable/bodysquat"
            ),
            ExerciseData(
                "Push-Ups",
                "1. Start in a plank position with your hands placed slightly wider than shoulder-width apart.\n" +
                        "2. Lower your body by bending your elbows while keeping your body in a straight line.\n" +
                        "3. Push back up to the starting position.",
                "beginner",
                "@drawable/pushup"
            )
        )

        val intermediateExercises = listOf(
            ExerciseData(
                "Squat",
                "1. Stand with your feet shoulder-width apart. \n" +
                        "2. Hold a barbell on your upper back.\n" +
                        "3. Bend your knees and hips to lower your body, keeping your back straight.\n" +
                        "4. Return to the starting position.",
                "intermediate",
                "@drawable/squat"
            ),
            ExerciseData(
                "Deadlift",
                "1. Stand with your feet hip-width apart, holding a barbell in front of you.\n" +
                        "2. Keeping your back straight, hinge at your hips and lower the barbell to the ground.\n" +
                        "3. Stand back up to the starting position.",
                "intermediate",
                "@drawable/deadlift"
            ),
            ExerciseData(
                "Bent Over Row",
                "1. Hold a dumbbell in each hand, hinge at your hips, and let the weights hang in front of you.\n" +
                        "2. Pull the weights to your chest, keeping your elbows close to your body.\n" +
                        "3. Lower the weights back down.",
                "intermediate",
                "@drawable/bentrow"
            )
        )

        val advancedExercises = listOf(
            ExerciseData(
                "Barbell Snatch",
                "1. Start with a barbell on the ground, feet shoulder-width apart.\n" +
                        "2. Bend at your hips and knees to lower into a squat position, grabbing the barbell with a wide grip.\n" +
                        "3. Explosively stand up, pulling the barbell overhead while extending your hips and knees.\n" +
                        "4. Drop into a squat and catch the barbell overhead.",
                "advanced",
                "@drawable/barbellsnatch"
            ),
            ExerciseData(
                "Muscle-Up",
                "1. Hang from a pull-up bar with a false grip.\n" +
                        "2. Explosively pull yourself up towards the bar while simultaneously transitioning your hands from below to above the bar.\n" +
                        "3. Finish by straightening your arms and pushing your chest forward.",
                "advanced",
                "@drawable/muscleup"
            ),
            ExerciseData(
                "Pistol Squat",
                "1. Stand on one leg with the other leg straight out in front of you.\n" +
                        "2. Lower into a squat position on the standing leg.\n" +
                        "3. Push back up to the starting position.",
                "advanced",
                "@drawable/pistolsquat"
            )
        )

        saveExercises("beginner", beginnerExercises)
        saveExercises("intermediate", intermediateExercises)
        saveExercises("advanced", advancedExercises)
    }
}
