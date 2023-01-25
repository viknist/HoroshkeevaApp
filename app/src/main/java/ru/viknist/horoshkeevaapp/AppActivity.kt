package ru.viknist.horoshkeevaapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class AppActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_app)
        supportActionBar?.hide()

        val settingsButtonImageView = findViewById<ImageView>(R.id.settingsButton)
        val welcomeNameTextView = findViewById<TextView>(R.id.welcomeNameTextView)
        val userInfo: TokenDataClass =
            getIntent().getSerializableExtra("userInfo") as TokenDataClass
        welcomeNameTextView.text = "Привет, ${userInfo.user?.username}"

        settingsButtonImageView.setOnClickListener {
            openSettingsActivity()
        }
    }

    private fun openSettingsActivity() {
        val intent = Intent(this, SettingsActivity::class.java)
        startActivity(intent)
    }
}