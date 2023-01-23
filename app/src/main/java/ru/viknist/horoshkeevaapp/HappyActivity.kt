package ru.viknist.horoshkeevaapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class HappyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_happy)
        supportActionBar?.hide()

        val continueButton = findViewById<TextView>(R.id.continueHappyTextView)

        continueButton.setOnClickListener {
            openAppActivity()
        }


    }

    private fun openAppActivity(){
        val intent = Intent(this, AppActivity::class.java)
        startActivity(intent)
    }
}