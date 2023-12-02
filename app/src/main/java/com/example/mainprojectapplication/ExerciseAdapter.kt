package com.example.mainprojectapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class ExerciseAdapter(private val exercises: ArrayList<ExerciseData>) :
    RecyclerView.Adapter<ExerciseAdapter.ExerciseViewHolder>() {

    class ExerciseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleTextView: TextView = itemView.findViewById(R.id.titleTextView)
        val splitTextView: TextView = itemView.findViewById(R.id.splitTextView)
        val imageView: ShapeableImageView = itemView.findViewById(R.id.imageView)
        val instructionTextView: TextView = itemView.findViewById(R.id.instructionTextView)
        val expandLinearLayout : LinearLayout = itemView.findViewById(R.id.expandableText)
        val mainConstraintlayout : ConstraintLayout = itemView.findViewById(R.id.mainConstraintlayout)

        fun collapseExpandedView(){
            instructionTextView.visibility = View.GONE
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExerciseViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_exercise, parent, false)
        return ExerciseViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ExerciseViewHolder, position: Int) {
        val exercise = exercises[position]

        holder.titleTextView.text = exercise.name
        holder.splitTextView.text = exercise.split
        holder.imageView.setImageResource(exercise.imagePath)
        holder.instructionTextView.text = exercise.instruction

        val visibility : Boolean = exercise.visibility
        holder.expandLinearLayout.visibility = if (visibility) View.VISIBLE else View.GONE

        holder.mainConstraintlayout.setOnClickListener {
            isAnyItemExpanded(position)
            exercise.visibility = !exercise.visibility
            notifyItemChanged(position)
        }
    }

    private fun isAnyItemExpanded(position: Int){
        val temp = exercises.indexOfFirst{
            it.visibility
        }

        if (temp >= 0 && temp != position){
            exercises[temp].visibility = false
            notifyItemChanged(temp, 0)
        }
    }

    override fun onBindViewHolder(holder: ExerciseViewHolder, position: Int, payloads: MutableList<Any>) {
        if(payloads.isNotEmpty() && payloads[0] == 0){
            holder.collapseExpandedView()
        }else{
            super.onBindViewHolder(holder, position, payloads)
        }
    }

    override fun getItemCount(): Int {
        return exercises.size
    }

}
