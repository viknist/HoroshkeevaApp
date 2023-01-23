package ru.viknist.horoshkeevaapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        supportActionBar?.hide()

        val registerButtonText = findViewById<TextView>(R.id.registerButtonTextView2)
        val loginButtonText = findViewById<TextView>(R.id.loginButtonTextView2)

        registerButtonText.setOnClickListener {
            val intent = Intent(this, ActivityChooseEmotion::class.java)
            startActivity(intent)
        }

        loginButtonText.setOnClickListener {
//            val intent = Intent(this, LoginActivity::class.java)
//            startActivity(intent)
            onBackPressed()
        }

    }
}