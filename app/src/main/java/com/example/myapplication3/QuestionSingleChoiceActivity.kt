package com.example.myapplication3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity

class QuestionSingleChoiceActivity : AppCompatActivity() {
    private var correctAnswers = 0
    private var incorrectAnswers = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question_single_choice)

        val previousCorrectAnswers = intent.getIntExtra("correctAnswers", 0)
        val previousIncorrectAnswers = intent.getIntExtra("incorrectAnswers", 0)
        correctAnswers = previousCorrectAnswers
        incorrectAnswers = previousIncorrectAnswers

        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        val nextButton = findViewById<Button>(R.id.nextButton)

        nextButton.setOnClickListener {
            val selectedRadioButtonId = radioGroup.checkedRadioButtonId
            if (selectedRadioButtonId != -1) {
                val selectedRadioButton = findViewById<RadioButton>(selectedRadioButtonId)
                val answer = selectedRadioButton.text.toString().trim().lowercase()
                if (answer == "юпитер") {
                    correctAnswers += 1
                } else {
                    incorrectAnswers += 1
                }

                val intent = Intent(this, QuestionMultipleChoiceActivity::class.java)
                intent.putExtra("correctAnswers", correctAnswers)
                intent.putExtra("incorrectAnswers", incorrectAnswers)
                startActivity(intent)
            }
        }
    }
}
