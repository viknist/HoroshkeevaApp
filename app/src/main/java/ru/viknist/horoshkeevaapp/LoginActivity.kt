package ru.viknist.horoshkeevaapp

import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        supportActionBar?.hide()

        val registerButtonText = findViewById<TextView>(R.id.registerButtonTextView)
        val loginButtonText = findViewById<TextView>(R.id.loginButtonTextView)

        val showHideButton = findViewById<ImageView>(R.id.showHidePasswordButton)
        val passwordEditText = findViewById<EditText>(R.id.editTextPasswordLogin)

        registerButtonText.setOnClickListener {
            openRegisterActivity()
        }

        loginButtonText.setOnClickListener {
            openChooseEmotionActivity()
        }

        showHideButton.setOnClickListener {
            Utils.showHidePassword(passwordEditText)
        }
    }

    private fun openRegisterActivity(){
        val intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)
    }

    private fun openChooseEmotionActivity(){
        val intent = Intent(this, ActivityChooseEmotion::class.java)
        startActivity(intent)
    }

}