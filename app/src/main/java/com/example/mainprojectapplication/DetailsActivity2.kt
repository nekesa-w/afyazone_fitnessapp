package com.example.mainprojectapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mainprojectapplication.databinding.ActivityDetails2Binding

class DetailsActivity2 : AppCompatActivity() {

    private lateinit var binding : ActivityDetails2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetails2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.finishButton.setOnClickListener {
            startActivity(Intent(this@DetailsActivity2,MainActivity::class.java))
            finish()
        }

    }
}