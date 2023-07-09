package com.joel.wits.screens

import android.content.res.Configuration
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.joel.wits.R
import com.joel.wits.components.StartPageStartQuizBottomToolBar
import com.joel.wits.components.StartPageToolBar
import com.joel.wits.ui.theme.WitsTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StartPage(
    onStartQuiz : () -> Unit
){



    val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.get_started_lottie))
    val progress by animateLottieCompositionAsState(
        composition = composition,
        iterations = LottieConstants.IterateForever,
        )

    Scaffold(
        topBar = {
            StartPageToolBar()
        },
        bottomBar = {
            StartPageStartQuizBottomToolBar(
                onStartQuiz = { onStartQuiz() }
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

@Preview(name = "StartPagePreview light theme", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview(name = "StartPagePreview dark theme", uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun StartPagePreview() {
    WitsTheme {

    }
}