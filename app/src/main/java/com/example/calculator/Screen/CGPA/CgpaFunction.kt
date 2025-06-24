package com.example.calculator.Screen.CGPA

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Calculate
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculator.R

@Composable
fun subjectText(subject : String)
{
    Spacer(modifier = Modifier.height(10.dp))
    Text(text =subject,
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp,
        modifier = Modifier.padding(start = 30.dp),
        color = colorResource(R.color.Dark_Blue)
    )
}

@Composable
fun textButton(
    modifier: Modifier = Modifier,
    valueState : MutableState<String>,
    labelId : String,
    enabled : Boolean,
    isSingleLine : Boolean,
    isError: Boolean = false,
    KeyBoardType : KeyboardType = KeyboardType.Number,
    imwAction: ImeAction = ImeAction.Next, // using next icon in keyboard
    onActions: KeyboardActions = KeyboardActions.Default
)
{
    OutlinedTextField(
        value = valueState.value,
        onValueChange = {valueState.value = it},
        label = { Text(text = labelId) },
        leadingIcon = { Icon(imageVector = Icons.Rounded.Calculate,
            contentDescription = " icon") },
        singleLine = isSingleLine,
        modifier = Modifier.padding(start = 30.dp, end = 30.dp, bottom = 10.dp)
            .fillMaxWidth(),
        textStyle = TextStyle(fontSize = 18.sp,
            color = colorResource(R.color.Dark_Blue)),
        enabled = enabled,
        isError = isError,
        keyboardOptions = KeyboardOptions(keyboardType = KeyBoardType,
            imeAction = imwAction),
        keyboardActions = onActions
    )

}