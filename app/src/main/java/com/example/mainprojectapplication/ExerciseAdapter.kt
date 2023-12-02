package com.example.mainprojectapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ExerciseAdapter(private val exercises: List<ExerciseData>) :
    RecyclerView.Adapter<ExerciseAdapter.ExerciseViewHolder>() {

    class ExerciseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleTextView: TextView = itemView.findViewById(R.id.titleTextView)
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
        val instructionTextView: TextView = itemView.findViewById(R.id.instructionTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExerciseViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_exercise, parent, false)
        return ExerciseViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ExerciseViewHolder, position: Int) {
        val exercise = exercises[position]

        holder.titleTextView.text = exercise.name

        val resourceId = exercise.imagePath.toInt()
        holder.imageView.setImageResource(resourceId)

        holder.instructionTextView.text = exercise.instruction
    }

    override fun getItemCount(): Int {
        return exercises.size
    }
}
