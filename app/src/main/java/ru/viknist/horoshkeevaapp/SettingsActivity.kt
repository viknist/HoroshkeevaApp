package ru.viknist.horoshkeevaapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.text.method.KeyListener
import android.widget.EditText
import android.widget.ImageView

class SettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        supportActionBar?.hide()

        val emailButtonImageView = findViewById<ImageView>(R.id.emailEditButtonImageView)
        val nameButtonImageView = findViewById<ImageView>(R.id.nameEditButtonImageView)
        val passwordButtonImageView = findViewById<ImageView>(R.id.passwordEditButtonImageView)
        val passwordShowButtonImageView = findViewById<ImageView>(R.id.showPasswordButtonImageView)

        val emailEditText = findViewById<EditText>(R.id.emailSettingsEditText)
        emailEditText.tag = emailEditText.keyListener
        emailEditText.keyListener = null
        val nameEditText = findViewById<EditText>(R.id.nameSettingsEditText)
        nameEditText.tag = nameEditText.keyListener
        nameEditText.keyListener = null
        val passwordEditText = findViewById<EditText>(R.id.passwordSettingsEditText)
        passwordEditText.tag = passwordEditText.keyListener
        passwordEditText.keyListener = null

        emailButtonImageView.setOnClickListener {
            if (emailEditText.keyListener != null) {
                emailEditText.keyListener = null
                emailButtonImageView.setImageResource(R.drawable.edit)
            } else {
                emailEditText.keyListener = emailEditText.tag as KeyListener?
                emailButtonImageView.setImageResource(R.drawable.savebutton)
            }
        }

        nameButtonImageView.setOnClickListener {
            if (nameEditText.keyListener != null){
                nameEditText.keyListener = null
                nameButtonImageView.setImageResource(R.drawable.edit)
            } else {
                nameEditText.keyListener = nameEditText.tag as KeyListener?
                nameButtonImageView.setImageResource(R.drawable.savebutton)
            }
        }

        passwordButtonImageView.setOnClickListener{
            if (passwordEditText.keyListener != null){
                passwordEditText.keyListener = null
                passwordButtonImageView.setImageResource(R.drawable.edit)
            } else {
                passwordEditText.keyListener = passwordEditText.tag as KeyListener?
                passwordButtonImageView.setImageResource(R.drawable.savebutton)
            }
        }

        passwordShowButtonImageView.setOnClickListener {
            println(passwordEditText.inputType)
            Utils.showHidePassword(passwordEditText)
        }

    }
}