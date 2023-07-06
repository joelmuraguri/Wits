package com.joel.wits.questions

interface GetAnswer{
    fun getCorrectAnswer(correctAnswer: String)
}

sealed class Answers<T>(val answer : T ? = null, val possibleAnswers: List<T> ?= null){
    class SingleChoiceQuestion<T>(answer: T) : Answers<T>(answer)
    class MultipleChoiceQuestion<T>(possibleAnswers: List<T>) : Answers<T>(possibleAnswers = possibleAnswers)
    class TrueOrFalseQuestions<T>(answer: T) : Answers<T>(answer)
    class FillInTheBlank<T>(answer: T) : Answers<T>(answer)
}

sealed class Questions<T>(
    val question:T,
    val possibleAnswers: List<T> ?= null,
    val answer: T ,
    val selectedAnswer : T ? = null,
    val optionSelected : T ? = null,
    val questionDirection : String ? = null
){
    class SingleChoiceQuestion<T>(answer: T) : Answers<T>(answer)
    class MultipleChoiceQuestion<T>(
        question: T, possibleAnswers: List<T>,
        answer: T,
    ) : Answers<T>(possibleAnswers = possibleAnswers)
    class TrueOrFalseQuestions<T>(answer: T) : Answers<T>(answer)
    class FillInTheBlank<T>(answer: T, question: T,questionDirection: String) : Answers<T>(answer)
}


enum class QuestionTypes(


){
    SINGLE_CHOICE_QUESTION,
    MULTIPLE_CHOICE_QUESTION,
    TRUE_OR_FALSE_QUESTION,
    FILL_IN_THE_BLANKS_QUESTION
}


object QuestionsManager{

}


data class SingleChoiceQuestion(
    val questionText: String,
    val correctAnswer: String,
    val usersAnswer: String?,
    val possibleAnswers: List<String>,
)


