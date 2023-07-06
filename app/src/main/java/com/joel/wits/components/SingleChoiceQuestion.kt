package com.joel.wits.components

import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import com.joel.wits.questions.SingleChoiceQuestion


@Composable
fun MultipleChoiceQuestion(
    @StringRes questionResourceId: Int,
    @StringRes directionsResourceId: Int,
    modifier: Modifier = Modifier,
    possibleAnswers: List<String>,
    selectedAnswer: String?,
    onChoiceSelected: (String) -> Unit,
    singleChoiceQuestion: SingleChoiceQuestion
){

    QuestionWrapper(
        questionResourceId = questionResourceId,
        directionsResourceId = directionsResourceId,
        modifier = modifier.selectableGroup(),
    ) {
        possibleAnswers.forEach {
            val selected = it == selectedAnswer
            RadioButtonWithText(
                modifier = Modifier.padding(vertical = 8.dp),
                text = stringResource(id = it.toInt()),
                selected = selected,
                onChoiceSelected = { onChoiceSelected(it) }
            )
        }
    }
}



@Composable
fun RadioButtonWithText(
    selected: Boolean,
    modifier: Modifier = Modifier,
    onChoiceSelected: () -> Unit,
    text : String
){

    Surface(
        shape = MaterialTheme.shapes.small,
        color = if (selected){
            MaterialTheme.colorScheme.primaryContainer
        } else
            MaterialTheme.colorScheme.surface,
        border = BorderStroke(
            width = 1.dp,
            color = if (selected) {
                MaterialTheme.colorScheme.primary
            } else {
                MaterialTheme.colorScheme.outline
            }
        ),
        modifier = modifier
            .clip(MaterialTheme.shapes.small)
            .selectable(
                selected,
                onClick = onChoiceSelected,
                role = Role.RadioButton
            )
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text, Modifier.weight(1f), style = MaterialTheme.typography.bodyLarge)
            Box(Modifier.padding(8.dp)) {
                RadioButton(selected, onClick = null)
            }
        }
    }
}