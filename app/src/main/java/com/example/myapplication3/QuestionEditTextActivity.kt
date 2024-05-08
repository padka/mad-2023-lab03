package com.example.myapplication3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class QuestionEditTextActivity : AppCompatActivity() {
    private var correctAnswers = 0
    private var incorrectAnswers = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question_edit_text)

        val previousCorrectAnswers = intent.getIntExtra("correctAnswers", 0)
        val previousIncorrectAnswers = intent.getIntExtra("incorrectAnswers", 0)
        correctAnswers = previousCorrectAnswers
        incorrectAnswers = previousIncorrectAnswers

        val answerEditText = findViewById<EditText>(R.id.answerEditText)
        val nextButton = findViewById<Button>(R.id.nextButton)

        nextButton.setOnClickListener {
            val answer = answerEditText.text.toString().trim().lowercase()
            if (answer == "париж") {
                correctAnswers += 1
            } else {
                incorrectAnswers += 1
            }

            val intent = Intent(this, QuestionSingleChoiceActivity::class.java)
            intent.putExtra("correctAnswers", correctAnswers)
            intent.putExtra("incorrectAnswers", incorrectAnswers)
            startActivity(intent)
        }
    }
}
