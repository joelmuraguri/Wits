package com.joel.wits

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.joel.wits.screens.QUIZ_ROUTE
import com.joel.wits.screens.QuizRoute
import com.joel.wits.screens.RESULT_ROUTE
import com.joel.wits.screens.ResultScreen
import com.joel.wits.screens.StartPage

@Composable
fun WitsApp(
    navController: NavHostController = rememberNavController(),
) {

    NavHost(
        navController = navController,
        startDestination = START_PAGE_ROUTE
    ){
        composable(START_PAGE_ROUTE){
            StartPage(
                onStartQuiz = {
                    navController.navigate(QUIZ_ROUTE)
                }
            )
        }
        composable(QUIZ_ROUTE){
            QuizRoute(
                onNavUp = navController::navigateUp,
                onSubmit = {
                    navController.navigate(RESULT_ROUTE)
                }
            )
        }
        composable(RESULT_ROUTE){
            ResultScreen(
              onStartQuiz = {
                  navController.navigate(START_PAGE_ROUTE)
              }
            )
        }
    }

}

const val START_PAGE_ROUTE = "start_page"