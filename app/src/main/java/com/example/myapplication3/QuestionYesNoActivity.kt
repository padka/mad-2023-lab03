package com.example.myapplication3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Switch
import androidx.appcompat.app.AppCompatActivity

class QuestionYesNoActivity : AppCompatActivity() {
    private var correctAnswers = 0
    private var incorrectAnswers = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question_yes_no)

        val switchYesNo = findViewById<Switch>(R.id.switchYesNo)
        val nextButton = findViewById<Button>(R.id.nextButton)

        nextButton.setOnClickListener {
            val isYes = switchYesNo.isChecked
            if (isYes) {
                correctAnswers += 1
            } else {
                incorrectAnswers += 1
            }

            val intent = Intent(this, QuestionEditTextActivity::class.java)
            intent.putExtra("correctAnswers", correctAnswers)
            intent.putExtra("incorrectAnswers", incorrectAnswers)
            startActivity(intent)
        }
    }
}
