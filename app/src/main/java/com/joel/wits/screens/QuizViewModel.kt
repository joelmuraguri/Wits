package com.joel.wits.screens

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.joel.wits.questions.DataSource
import com.joel.wits.questions.SingleChoiceQuestion

class QuizViewModel : ViewModel() {

    private val questions = DataSource.multipleChoicesQuestion

    private var questionIndex = 0

    private var _isNextEnabled = mutableStateOf(false)
    val isNextEnabled : Boolean
        get() = _isNextEnabled.value

    private var _quizData = mutableStateOf(createQuizData())
    val quizData : QuizData?
        get() = _quizData.value

    private var _choiceResponse = mutableStateOf<String?>(null)
    val choiceResponse : String?
        get() = _choiceResponse.value

    //Will be used in optionSelected parameter to check on answer selected and next to enable next button
    fun onPossibleAnswersResponse(answer : String){
        _choiceResponse.value = answer
        _isNextEnabled.value = getNextEnabled()
    }

    //used to handle state of quizData view state
    private fun createQuizData() : QuizData{
        return QuizData(
            showPreviousButton = questionIndex > 0,
            showSubmitButton = questionIndex == questions.size -1,
            questionIndex = questionIndex,
            totalQuestions = questions.size,
            multipleChoice = questions
        )
    }

    fun onBackPressed() : Boolean{
        if (questionIndex == 0){
            return false
        }
        changeQuestion(questionIndex - 1)
        return true
    }

    //handles on previous pressed button by navigating back in reference to list size
    fun onPreviousPressed(){
        if (questionIndex == 0){
            throw IllegalStateException("onPreviousPressed when on question 0")
        }
        changeQuestion(questionIndex - 1)
    }

    //handles on next pressed button by navigating to the next question in reference to list size
    fun onNextPressed(){
        changeQuestion(questionIndex +1 )
    }

    fun onSubmit(onQuizComplete : () -> Unit){
        /* marks/validates quiz and gives score on next screen */
        onQuizComplete()
    }

    //enables the next button only if a choice is selected
    private fun getNextEnabled(enabled : Boolean = true) : Boolean {
        val value =  if (enabled){
            _choiceResponse.value != null
        } else {
            return false
        }
        return value
    }

    //handles navigating from question to question either previous or next question
    private fun changeQuestion(newQuestion : Int){
        questionIndex = newQuestion
        _quizData.value = createQuizData()
        _isNextEnabled.value = getNextEnabled()
    }


}

//view state for the quiz view
data class QuizData(
    val showPreviousButton : Boolean,
    val showSubmitButton : Boolean,
    val questionIndex : Int,
    val totalQuestions : Int,
    val multipleChoice: List<SingleChoiceQuestion>
)