package ru.viknist.horoshkeevaapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SadActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sad)
        supportActionBar?.hide()
    }
}