package com.example.quizapp.model

data class Question (
    val id: Int,
    val question: String,
    val image: Int, //drawable stores images in Ints
    val optionOne: String,
    val optionTwo: String,
    val optionThree: String,
    val optionFour: String,
    val correctAnswer: Int
)