package com.joel.wits.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.joel.wits.R
import com.joel.wits.components.ResultBottomToolBar

const val RESULT_ROUTE = "result"

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ResultScreen(
    onStartQuiz : () -> Unit
){

    val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.passed_lottie))
    val progress by animateLottieCompositionAsState(
        composition = composition,
        iterations = LottieConstants.IterateForever,
    )

    Scaffold(
        bottomBar = {
            ResultBottomToolBar(
                onStartQuiz = onStartQuiz
            )
        }
    ) { paddingValues ->

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            LottieAnimation(composition = composition, progress = progress)
        }

    }

}