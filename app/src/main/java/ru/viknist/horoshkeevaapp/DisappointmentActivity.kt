package ru.viknist.horoshkeevaapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class DisappointmentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_disappointment)
        supportActionBar?.hide()
    }
}