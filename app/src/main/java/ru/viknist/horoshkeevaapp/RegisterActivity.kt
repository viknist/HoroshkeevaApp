package ru.viknist.horoshkeevaapp

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import retrofit2.HttpException

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        supportActionBar?.hide()

        val registerButtonText = findViewById<TextView>(R.id.registerButtonTextView2)
        val loginButtonText = findViewById<TextView>(R.id.loginButtonTextView2)
        val emailEditText = findViewById<EditText>(R.id.emailRegisterEditText)
        val nameEditText = findViewById<EditText>(R.id.nameRegisterEditText)
        val passwordEditText = findViewById<EditText>(R.id.editTextPasswordRegister)
        val passwordRepeatEditText = findViewById<EditText>(R.id.editTextRepeatPasswordRegister)
        val errorTextView = findViewById<TextView>(R.id.errorTextView)

        registerButtonText.setOnClickListener {
            val registerInfo = RegisterDataClass(
                emailEditText.text.toString(),
                emailEditText.text.toString(),
                passwordEditText.text.toString(),
                passwordRepeatEditText.text.toString(),
                nameEditText.text.toString()
            )

            errorTextView.visibility = View.INVISIBLE
            lifecycleScope.launch {
                try {
                    val tokenInfo =
                        ServiceBuilder.buildService(RestApi::class.java).registerUser(registerInfo)
                    println(tokenInfo.toString())
                    errorTextView.visibility = View.INVISIBLE
                    openChooseEmotionActivity(tokenInfo)
                } catch (e: HttpException) {
                    if (e.code() == 400)
                        errorTextView.visibility = View.VISIBLE
                }
            }
        }

        loginButtonText.setOnClickListener {
            onBackPressed()
        }

    }

    private fun openChooseEmotionActivity(userInfo: TokenDataClass) {
        val intent = Intent(this, ActivityChooseEmotion::class.java)
        intent.putExtra("userInfo", userInfo)
        startActivity(intent)
    }
}