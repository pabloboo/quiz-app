package com.example.quizapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import com.example.quizapp.R
import com.example.quizapp.model.Question
import com.example.quizapp.utils.Constants

class QuestionsActivity : AppCompatActivity() {
    private lateinit var progressBar : ProgressBar
    private lateinit var textViewProgress : TextView
    private lateinit var textViewQuestion : TextView
    private lateinit var flagImage : ImageView
    private lateinit var textViewOption1 : TextView
    private lateinit var textViewOption2 : TextView
    private lateinit var textViewOption3 : TextView
    private lateinit var textViewOption4 : TextView
    private val currentPosition = 1
    private lateinit var questionsList: MutableList<Question>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)

        progressBar = findViewById(R.id.progress_bar)
        textViewProgress = findViewById(R.id.text_view_progress)
        textViewQuestion = findViewById(R.id.question_text_view)
        flagImage = findViewById(R.id.image_flag)
        textViewOption1 = findViewById(R.id.text_view_option1)
        textViewOption2 = findViewById(R.id.text_view_option2)
        textViewOption3 = findViewById(R.id.text_view_option3)
        textViewOption4 = findViewById(R.id.text_view_option4)

        questionsList = Constants.getQuestions()
        Log.d("QuestionSize", "${questionsList.size}")

        setQuestion()
    }

    private fun setQuestion() {
        val question = questionsList[currentPosition - 1]
        flagImage.setImageResource(question.image)
        progressBar.progress = currentPosition
        textViewProgress.text = "$currentPosition/${progressBar.max}"
        textViewQuestion.text = question.question
        textViewOption1.text = question.optionOne
        textViewOption2.text = question.optionTwo
        textViewOption3.text = question.optionThree
        textViewOption4.text = question.optionFour
    }
}