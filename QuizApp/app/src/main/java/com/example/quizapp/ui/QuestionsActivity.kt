package com.example.quizapp.ui

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.quizapp.R
import com.example.quizapp.model.Question
import com.example.quizapp.utils.Constants

class QuestionsActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var progressBar : ProgressBar
    private lateinit var textViewProgress : TextView
    private lateinit var textViewQuestion : TextView
    private lateinit var flagImage : ImageView

    private lateinit var textViewOption1 : TextView
    private lateinit var textViewOption2 : TextView
    private lateinit var textViewOption3 : TextView
    private lateinit var textViewOption4 : TextView

    private lateinit var checkButton: Button

    private val currentPosition = 1
    private lateinit var questionsList: MutableList<Question>
    private var selectedOptionPosition = 0
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
        checkButton = findViewById(R.id.button_check)

        textViewOption1.setOnClickListener(this)
        textViewOption2.setOnClickListener(this)
        textViewOption3.setOnClickListener(this)
        textViewOption4.setOnClickListener(this)
        checkButton.setOnClickListener(this)

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

        if (currentPosition == questionsList.size) {
            checkButton.text = "Finish"
        } else {
            checkButton.text = "Check"
        }
    }

    private fun resetOptions() {
        val options = mutableListOf<TextView>()
        options.add(textViewOption1)
        options.add(textViewOption2)
        options.add(textViewOption3)
        options.add(textViewOption4)

        for (option in options) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.default_option_border_bg
            )
        }
    }

    private fun selectedOption(textView: TextView, selectedOptionNumber: Int) {
        resetOptions()

        selectedOptionPosition = selectedOptionNumber
        textView.setTextColor(Color.parseColor("#363A43"))
        textView.setTypeface(textView.typeface, Typeface.BOLD)
        textView.background = ContextCompat.getDrawable(

            this,
            R.drawable.selected_option_border_bg
        )
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.text_view_option1 -> {
                selectedOption(textViewOption1, 1)
            }
            R.id.text_view_option2 -> {
                selectedOption(textViewOption2, 2)
            }
            R.id.text_view_option3 -> {
                selectedOption(textViewOption3, 3)
            }
            R.id.text_view_option4 -> {
                selectedOption(textViewOption4, 4)
            }
            R.id.button_check -> {

            }
        }
    }
}