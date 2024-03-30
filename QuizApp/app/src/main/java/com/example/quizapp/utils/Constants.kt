package com.example.quizapp.utils

import com.example.quizapp.R
import com.example.quizapp.model.Question

object Constants {

    fun getQuestions(): MutableList<Question> {
        val questions = mutableListOf<Question>()

        val questItaly = Question(
            1,
            "What country does this flag belong?",
            R.drawable.italy_flag,
            "Italy",
            "India",
            "Iran",
            "Ireland",
            1
        )
        questions.add(questItaly)

        val questSpain = Question(
            2,
            "What country does this flag belong?",
            R.drawable.spain_flag,
            "Portugal",
            "Mexico",
            "Argentina",
            "Spain",
            4
        )
        questions.add(questSpain)

        val questRomania = Question(
            3,
            "What country does this flag belong?",
            R.drawable.romania_flag,
            "Hungary",
            "Bulgaria",
            "Romania",
            "Serbia",
            3
        )
        questions.add(questRomania)

        val questNigeria = Question(
            4,
            "What country does this flag belong?",
            R.drawable.nigeria_flag,
            "Ghana",
            "Kenya",
            "Nigeria",
            "South Africa",
            3
        )
        questions.add(questNigeria)

        val questIndia = Question(
            5,
            "What country does this flag belong?",
            R.drawable.india_flag,
            "India",
            "Bangladesh",
            "Pakistan",
            "Sri Lanka",
            1
        )
        questions.add(questIndia)

        val questGermany = Question(
            6,
            "What country does this flag belong?",
            R.drawable.germany_flag,
            "Austria",
            "Germany",
            "Switzerland",
            "Netherlands",
            1
        )
        questions.add(questGermany)

        val questGalician = Question(
            7,
            "What region does this flag belong?",
            R.drawable.galician_flag,
            "Galicia",
            "Basque Country",
            "Catalonia",
            "Andalusia",
            1
        )
        questions.add(questGalician)

        val questFrance = Question(
            8,
            "What country does this flag belong?",
            R.drawable.france_flag,
            "Belgium",
            "France",
            "Italy",
            "Luxembourg",
            1
        )
        questions.add(questFrance)

        val questFinland = Question(
            9,
            "What country does this flag belong?",
            R.drawable.finland_flag,
            "Denmark",
            "Norway",
            "Sweden",
            "Finland",
            4
        )
        questions.add(questFinland)

        return questions
    }
}