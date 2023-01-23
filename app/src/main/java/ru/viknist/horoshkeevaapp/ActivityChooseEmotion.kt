package ru.viknist.horoshkeevaapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.core.view.setPadding
import kotlin.math.E

class ActivityChooseEmotion : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_emotion)
        supportActionBar?.hide()


        val happyImageView = findViewById<ImageView>(R.id.happyImageView)
        val sadImageView = findViewById<ImageView>(R.id.sadImageView)
        val disappointmentImageView = findViewById<ImageView>(R.id.disappointmentImageView)
        val angryImageView = findViewById<ImageView>(R.id.angryImageView)
        val fearImageView = findViewById<ImageView>(R.id.fearImageView)
        var selectedEmotion: Emotion? = null

        happyImageView.setOnClickListener{
            if (selectedEmotion == Emotion.HAPPY)
                openEmotionActivity(Emotion.HAPPY)
            else {
                selectedEmotion = Emotion.HAPPY
                happyImageView.setPadding(1,1,1,1)
                sadImageView.setPadding(0,0,0,0)
                disappointmentImageView.setPadding(0,0,0,0)
                angryImageView.setPadding(0,0,0,0)
                fearImageView.setPadding(0,0,0,0)
            }
        }
        sadImageView.setOnClickListener {
            if (selectedEmotion == Emotion.SAD)
                openEmotionActivity(Emotion.SAD)
            else{
                selectedEmotion = Emotion.SAD
                happyImageView.setPadding(0,0,0,0)
                sadImageView.setPadding(1,1,1,1)
                disappointmentImageView.setPadding(0,0,0,0)
                angryImageView.setPadding(0,0,0,0)
                fearImageView.setPadding(0,0,0,0)
            }
        }
        disappointmentImageView.setOnClickListener {
            if (selectedEmotion == Emotion.DISAPPOINTED)
                openEmotionActivity(Emotion.DISAPPOINTED)
            else{
                selectedEmotion = Emotion.DISAPPOINTED
                happyImageView.setPadding(0,0,0,0)
                sadImageView.setPadding(0,0,0,0)
                disappointmentImageView.setPadding(1,1,1,1)
                angryImageView.setPadding(0,0,0,0)
                fearImageView.setPadding(0,0,0,0)
            }
        }
        angryImageView.setOnClickListener {
            if (selectedEmotion == Emotion.ANGRY)
                openEmotionActivity(Emotion.ANGRY)
            else{
                selectedEmotion = Emotion.ANGRY
                happyImageView.setPadding(0,0,0,0)
                sadImageView.setPadding(0,0,0,0)
                disappointmentImageView.setPadding(0,0,0,0)
                angryImageView.setPadding(1,1,1,1)
                fearImageView.setPadding(0,0,0,0)
            }
        }
        fearImageView.setOnClickListener {
            if (selectedEmotion == Emotion.FEAR)
                openEmotionActivity(Emotion.FEAR)
            else{
                selectedEmotion = Emotion.FEAR
                happyImageView.setPadding(0,0,0,0)
                sadImageView.setPadding(0,0,0,0)
                disappointmentImageView.setPadding(0,0,0,0)
                angryImageView.setPadding(0,0,0,0)
                fearImageView.setPadding(1,1,1,1)
            }
        }
    }

    private fun openEmotionActivity(emotion: Emotion){
        val intent = when(emotion) {
            Emotion.HAPPY -> Intent(this, HappyActivity::class.java)
            Emotion.ANGRY -> Intent(this, AngryActivity::class.java)
            Emotion.FEAR -> Intent(this, FearActivity::class.java)
            Emotion.SAD -> Intent(this, SadActivity::class.java)
            Emotion.DISAPPOINTED -> Intent(this, DisappointmentActivity::class.java)
        }
        startActivity(intent)
    }
}