package ru.viknist.emotionsrest.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import ru.viknist.emotionsrest.AppActivity
import ru.viknist.emotionsrest.models.EmotionModel
import ru.viknist.emotionsrest.models.UserToken
import ru.viknist.emotionsrest.network.RestApi
import ru.viknist.emotionsrest.network.ServiceBuilder
import ru.viknist.horoshkeevaapp.R

class SadActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sad)
        supportActionBar?.hide()

        val continueButton = findViewById<TextView>(R.id.continueSadTextView)
        val sadEditText = findViewById<EditText>(R.id.sadEditText)
        val userInfo =
            intent.getSerializableExtra("userInfo") as UserToken

        continueButton.setOnClickListener {
            lifecycleScope.launch {
                try {
                    val emotionModel = EmotionModel(sadEditText.text.toString(), "sad")
                    ServiceBuilder.buildService(RestApi::class.java).postNote(emotionModel, "Bearer ${userInfo.accessToken}")
                    openAppActivity()
                } catch (e: Exception) {
                    Toast.makeText(applicationContext, "Ошибка ${e.message}", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun openAppActivity() {
        val intent = Intent(this, AppActivity::class.java)
        intent.putExtra("userInfo", getIntent().getSerializableExtra("userInfo") as UserToken)
        startActivity(intent)
    }
}