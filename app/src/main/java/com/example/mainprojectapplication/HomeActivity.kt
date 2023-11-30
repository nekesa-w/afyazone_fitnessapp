package com.example.mainprojectapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mainprojectapplication.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding : ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loginbutton.setOnClickListener {
            startActivity(Intent(this@HomeActivity,LoginActivity::class.java))
            finish()
        }

        binding.signupbutton.setOnClickListener {
            startActivity(Intent(this@HomeActivity,SignupActivity::class.java))
            finish()
        }
    }
}