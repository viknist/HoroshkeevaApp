package ru.viknist.horoshkeevaapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class FearActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fear)
        supportActionBar?.hide()
    }
}