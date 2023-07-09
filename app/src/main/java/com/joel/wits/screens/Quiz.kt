package com.joel.wits.screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.joel.wits.components.QuizBottomBar
import com.joel.wits.components.QuizTopBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuizScreen(
    content: @Composable (PaddingValues) -> Unit,
    quizData: QuizData,
    isNextEnabled : Boolean,
    onPreviousPressed : () -> Unit,
    onSubmitPressed : () -> Unit,
    onNextPressed : () -> Unit,
    onClosePressed : () -> Unit,
){

    Scaffold(
        bottomBar = {
            QuizBottomBar(
                showPreviousButton = quizData.showPreviousButton,
                showSubmitButton = quizData.showSubmitButton,
                onPreviousPressed = { onPreviousPressed()},
                onSubmitPressed = { onSubmitPressed() },
                onNextPressed = { onNextPressed() },
                isNextButtonEnabled = isNextEnabled
            )
        },
        topBar = {
            QuizTopBar(
                onClosePressed = { onClosePressed() },
                questionIndex = quizData.questionIndex,
                totalQuestions = quizData.totalQuestions)
        },
        content = content
    )

}