package com.joel.wits.screens

import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.TweenSpec
import androidx.compose.animation.core.tween
import androidx.compose.animation.with
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.joel.wits.components.MultipleChoiceQuestion

const val QUIZ_ROUTE = "quiz"
private const val CONTENT_ANIMATION_DURATION = 300


@OptIn(ExperimentalAnimationApi::class)
@Composable
fun QuizRoute(
    onNavUp : () -> Unit,
    onSubmit : () -> Unit
){

    val quizViewModel : QuizViewModel = viewModel()

    val quizData = quizViewModel.quizData ?: return


    BackHandler {
        if (!quizViewModel.onBackPressed()){
            onNavUp()
        }
    }

    QuizScreen(
        content = { paddingValues ->
            val modifier = Modifier.padding(paddingValues)
            AnimatedContent(
                targetState = quizData,
                transitionSpec = {
                    val animationSpec: TweenSpec<IntOffset> =
                        tween(CONTENT_ANIMATION_DURATION)
                    val direction = getTransitionDirection(
                        initialIndex = initialState.questionIndex,
                        targetIndex = targetState.questionIndex,
                    )
                    slideIntoContainer(
                        towards = direction,
                        animationSpec = animationSpec,
                    ) with slideOutOfContainer(
                        towards = direction,
                        animationSpec = animationSpec
                    )
                }
            ) { targetState ->
                if (targetState.multipleChoice.isNotEmpty()){
                    MultipleChoiceQuestion(
                        singleChoiceQuestion = quizData.multipleChoice[targetState.questionIndex],
                        selectedAnswer = quizViewModel.choiceResponse,
                        onChoiceSelected = quizViewModel::onPossibleAnswersResponse,
                        modifier = modifier
                    )
                } else {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier.fillMaxSize()
                    ){
                        Text(
                            text = "QUIZES SHOULD BE HERE, AN UNEXPECTED ERROR OCCURRED",
                            fontSize = 24.sp
                        )
                    }
                }
            }
        },
        quizData = quizData,
        isNextEnabled = quizViewModel.isNextEnabled,
        onPreviousPressed = { quizViewModel.onPreviousPressed() },
        onSubmitPressed = { quizViewModel.onSubmit(onSubmit) },
        onNextPressed = { quizViewModel.onNextPressed() },
        onClosePressed = { onNavUp() }
    )
}

@OptIn(ExperimentalAnimationApi::class)
private fun getTransitionDirection(
    initialIndex: Int,
    targetIndex: Int
): AnimatedContentScope.SlideDirection {
    return if (targetIndex > initialIndex) {
        // Going forwards in the survey: Set the initial offset to start
        // at the size of the content so it slides in from right to left, and
        // slides out from the left of the screen to -fullWidth
        AnimatedContentScope.SlideDirection.Left
    } else {
        // Going back to the previous question in the set, we do the same
        // transition as above, but with different offsets - the inverse of
        // above, negative fullWidth to enter, and fullWidth to exit.
        AnimatedContentScope.SlideDirection.Right
    }
}