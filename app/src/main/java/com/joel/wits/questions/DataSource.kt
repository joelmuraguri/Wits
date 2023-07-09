package com.joel.wits.questions

object DataSource {


    val multipleChoicesQuestion = listOf(
        SingleChoiceQuestion(
            questionText = "What is the 9 x 9",
            correctAnswer = "81",
            possibleAnswers = listOf(
                "1",
                "3",
                "4",
                "81"
            ),
            usersAnswer = "0",
        ),
        SingleChoiceQuestion(
            questionText = "When did Kenya become a republic",
            correctAnswer = "1964",
            possibleAnswers = listOf(
                "2010",
                "1964",
                "1978",
                "1992"
            ),
            usersAnswer = "1992"
        ),
        SingleChoiceQuestion(
            questionText = "How many counties are in Kenya?",
            correctAnswer = "47",
            possibleAnswers = listOf(
                "290",
                "47",
                "1500",
                "8"
            ),
            usersAnswer = "47"
        ),
        SingleChoiceQuestion(
            questionText = "The capital city of Kenya?",
            correctAnswer = "Nairobi",
            possibleAnswers = listOf(
                "Mombasa",
                "Kisumu",
                "Nairobi",
                "Nakuru"
            ),
            usersAnswer = "Nakuru"
        ),
    )
}