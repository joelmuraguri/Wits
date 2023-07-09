package com.joel.wits.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.joel.wits.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StartPageToolBar(){
    
    TopAppBar(
        navigationIcon = {
            Text(text = "Hello, Joel")
        },
        title = {},
        actions = {
            //TODO should launch bottom sheets with option to filter TODO
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    painter = painterResource(id = R.drawable.round_filter_24),
                    contentDescription = stringResource(id = R.string.filter_icon))
            }
        },
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 20.dp)
    )
}

@Composable
fun StartPageStartQuizBottomToolBar(
    onStartQuiz : () -> Unit
){

    Surface(
        modifier = Modifier
         .fillMaxWidth(),
        shadowElevation = 8.dp
    ) {
        Button(
            onClick = { onStartQuiz() },
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 20.dp)
                .height(50.dp)
        ) {
            Text(text = "START QUIZ")
        }
    }
}

@Composable
fun QuizBottomBar(
    showPreviousButton : Boolean,
    showSubmitButton : Boolean,
    onPreviousPressed : () -> Unit,
    onSubmitPressed : () -> Unit,
    onNextPressed : () -> Unit,
    isNextButtonEnabled : Boolean
){

    Surface(
        modifier = Modifier
            .fillMaxWidth(),
        shadowElevation = 8.dp
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 20.dp)
        ) {
            if (showPreviousButton){
                OutlinedButton(
                    onClick = { onPreviousPressed() },
                    modifier = Modifier
                        .weight(1f)
                        .height(50.dp)
                ) {
                    Text(text = stringResource(id = R.string.previous_button))
                }
            }
            if (showSubmitButton){
                OutlinedButton(
                    onClick = { onSubmitPressed() },
                    modifier = Modifier
                        .weight(1f)
                        .height(50.dp)
                ) {
                    Text(text = stringResource(id = R.string.submit_button))
                }
            } else {
                Button(
                    onClick = { onNextPressed() },
                    modifier = Modifier
                        .weight(1f)
                        .height(50.dp),
                    enabled = isNextButtonEnabled
                ) {
                    Text(text = stringResource(id = R.string.next_button))
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuizTopBar(
    onClosePressed : () -> Unit,
    questionIndex : Int,
    totalQuestions : Int,
){

    Column(
        modifier = Modifier
            .fillMaxWidth()
    ){
        CenterAlignedTopAppBar(
            title = {
                TopAppBarTitle(
                    questionIndex = questionIndex,
                    totalQuestionsCount = totalQuestions)
            },
            actions = {
                IconButton(onClick = { onClosePressed() }) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = stringResource(id = R.string.close_icon))
                }
            }
        )
        val animatedFloatProgress by animateFloatAsState(
            targetValue = (questionIndex + 1) / totalQuestions.toFloat(),
            animationSpec = ProgressIndicatorDefaults.ProgressAnimationSpec
        )
        LinearProgressIndicator(
            progress = animatedFloatProgress,
            trackColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.2F),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        )
    }
}

@Composable
private fun TopAppBarTitle(
    questionIndex: Int,
    totalQuestionsCount: Int,
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier) {
        Text(
            text = (questionIndex + 1).toString(),
            style = MaterialTheme.typography.labelMedium,
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = stronglyDeemphasizedAlpha)
        )
        Text(
            text = stringResource(R.string.question_count, totalQuestionsCount),
            style = MaterialTheme.typography.labelMedium,
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f)
        )
    }
}

@Composable
fun ResultBottomToolBar(
    onStartQuiz: () -> Unit
){
    Surface(
        modifier = Modifier
            .fillMaxWidth(),
        shadowElevation = 8.dp
    ) {
        Button(
            onClick = { onStartQuiz() },
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 20.dp)
                .height(50.dp)
        ) {
            Text(text = "TAKE QUIZ")
        }
    }
}