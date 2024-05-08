package com.example.myapplication3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import androidx.appcompat.app.AppCompatActivity

class QuestionMultipleChoiceActivity : AppCompatActivity() {
    private var correctAnswers = 0
    private var incorrectAnswers = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question_multiple_choice)

        val previousCorrectAnswers = intent.getIntExtra("correctAnswers", 0)
        val previousIncorrectAnswers = intent.getIntExtra("incorrectAnswers", 0)
        correctAnswers = previousCorrectAnswers
        incorrectAnswers = previousIncorrectAnswers

        val checkBoxPython = findViewById<CheckBox>(R.id.checkBoxPython)
        val checkBoxRuby = findViewById<CheckBox>(R.id.checkBoxRuby)
        val checkBoxHTML = findViewById<CheckBox>(R.id.checkBoxHTML)
        val checkBoxJava = findViewById<CheckBox>(R.id.checkBoxJava)
        val nextButton = findViewById<Button>(R.id.nextButton)

        nextButton.setOnClickListener {
            val correctLanguages = listOf("python", "ruby", "java")
            val selectedAnswers = mutableListOf<String>()

            if (checkBoxPython.isChecked) selectedAnswers.add("python")
            if (checkBoxRuby.isChecked) selectedAnswers.add("ruby")
            if (checkBoxHTML.isChecked) selectedAnswers.add("html")
            if (checkBoxJava.isChecked) selectedAnswers.add("java")

            correctAnswers += selectedAnswers.count { it in correctLanguages }
            incorrectAnswers += selectedAnswers.count { it !in correctLanguages }

            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("correctAnswers", correctAnswers)
            intent.putExtra("incorrectAnswers", incorrectAnswers)
            startActivity(intent)
        }
    }
}
