package com.joel.wits.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
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
fun StartPageStartQuizBottomToolBar(){

    Surface(
        modifier = Modifier
         .fillMaxWidth(),
        shadowElevation = 8.dp
    ) {
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 20.dp)
                .height(50.dp)
        ) {
            Text(text = "START QUIZ")
        }
    }

}