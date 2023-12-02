package com.example.mainprojectapplication

import androidx.appcompat.app.AppCompatActivity

class ExerciseAdd : AppCompatActivity() {

    lateinit var beginner: ArrayList<ExerciseData>
    lateinit var intermediate: ArrayList<ExerciseData>
    lateinit var advanced: ArrayList<ExerciseData>

    fun addExercises() {
        beginner = ArrayList<ExerciseData>().apply {
            add(
                ExerciseData(
                    "Jumping Jacks",
                    "1. Stand with your feet together and arms at your sides.\n" +
                            "2. Jump, landing with your feet shoulder-width apart while bringing your arms overhead.\n" +
                            "3. Jump again, returning to the starting position.",
                    "beginner",
                    "Full",
                    R.drawable.jumpjack,
                    false
                )
            )
            add(
                ExerciseData(
                    "Bodyweight Squats",
                    "1. Stand with your feet shoulder-width apart.\n" +
                            "2. Lower your body by pushing your hips back and bending your knees.\n" +
                            "3. Keep your back straight, chest up, and knees aligned with your toes.\n" +
                            "4. Return to the starting position by pushing through your heels.",
                    "beginner",
                    "Lower",
                    R.drawable.bodysquat,
                    false
                )
            )
            add(
                ExerciseData(
                    "Push-Ups",
                    "1. Start in a plank position with your hands placed slightly wider than shoulder-width apart.\n" +
                            "2. Lower your body by bending your elbows while keeping your body in a straight line.\n" +
                            "3. Push back up to the starting position.",
                    "beginner",
                    "Upper",
                    R.drawable.pushup,
                    false
                )
            )
        }

        intermediate = ArrayList<ExerciseData>().apply {
            add(
                ExerciseData(
                    "Squat",
                    "1. Stand with your feet shoulder-width apart. \n" +
                            "2. Hold a barbell on your upper back.\n" +
                            "3. Bend your knees and hips to lower your body, keeping your back straight.\n" +
                            "4. Return to the starting position.",
                    "intermediate",
                    "Lower",
                    R.drawable.squat,
                    false
                )
            )
            add(
                ExerciseData(
                    "Deadlift",
                    "1. Stand with your feet hip-width apart, holding a barbell in front of you.\n" +
                            "2. Keeping your back straight, hinge at your hips and lower the barbell to the ground.\n" +
                            "3. Stand back up to the starting position.",
                    "intermediate",
                    "Lower",
                    R.drawable.deadlift,
                    false
                )
            )
            add(
                ExerciseData(
                    "Bent Over Row",
                    "1. Hold a dumbbell in each hand, hinge at your hips, and let the weights hang in front of you.\n" +
                            "2. Pull the weights to your chest, keeping your elbows close to your body.\n" +
                            "3. Lower the weights back down.",
                    "intermediate",
                    "Upper",
                    R.drawable.bentrow,
                    false
                )
            )
            add(
                ExerciseData(
                    "Full-Body Plank",
                    "1. Start in a plank position with your hands directly under your shoulders.\n" +
                            "2. Engage your core and keep your body in a straight line from head to heels.\n" +
                            "3. Lower your body down to your forearms, one arm at a time, maintaining the plank position.\n" +
                            "4. Push back up to the starting plank position.\n" +
                            "5. Repeat for the desired number of repetitions.",
                    "intermediate",
                    "Full",
                    R.drawable.fullbodyplank,
                    false
                )
            )
        }

        advanced = ArrayList<ExerciseData>().apply {
            add(
                ExerciseData(
                    "Barbell Snatch",
                    "1. Start with a barbell on the ground, feet shoulder-width apart.\n" +
                            "2. Bend at your hips and knees to lower into a squat position, grabbing the barbell with a wide grip.\n" +
                            "3. Explosively stand up, pulling the barbell overhead while extending your hips and knees.\n" +
                            "4. Drop into a squat and catch the barbell overhead.",
                    "advanced",
                    "Full",
                    R.drawable.barbellsnatch,
                    false
                )
            )
            add(
                ExerciseData(
                    "Muscle-Up",
                    "1. Hang from a pull-up bar with a false grip.\n" +
                            "2. Explosively pull yourself up towards the bar while simultaneously transitioning your hands from below to above the bar.\n" +
                            "3. Finish by straightening your arms and pushing your chest forward.",
                    "advanced",
                    "Upper",
                    R.drawable.muscleup,
                    false
                )
            )
            add(
                ExerciseData(
                    "Pistol Squat",
                    "1. Stand on one leg with the other leg straight out in front of you.\n" +
                            "2. Lower into a squat position on the standing leg.\n" +
                            "3. Push back up to the starting position.",
                    "advanced",
                    "Lower",
                    R.drawable.pistolsquat,
                    false
                )
            )
        }
    }
}