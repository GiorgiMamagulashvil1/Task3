package com.example.task3compose.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.task3compose.R

@ExperimentalComposeUiApi
@Composable
fun MainScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        MainSections(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.8f)
                .background(color = colorResource(id = R.color.background_yellow))

        )
        GetStartedSection(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.1f)
                .background(colorResource(id = R.color.background_blue))
        )
        BottomNavSection(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .weight(0.1f)
        )
    }
}

@ExperimentalComposeUiApi
@Composable
fun MainSections(
    modifier: Modifier = Modifier
) {
    ConstraintLayout(
        modifier = modifier
    ) {
        val (icon, userNameEditText, passwordEditText) = createRefs()
        Icon(
            Icons.Default.Message,
            contentDescription = null,
            tint = Color.Black,
            modifier = Modifier
                .size(64.dp)
                .constrainAs(icon) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
        )
        var usernameTextValue by remember {
            mutableStateOf("abcd@gmail.com")
        }
        var passwordTextValue by remember {
            mutableStateOf("Password")
        }
        TextField(
            value = usernameTextValue,
            onValueChange = { newValue -> usernameTextValue = newValue },
            label = {
                Text(text = "Username", color = Color.Black)
            },
            singleLine = true,
            modifier = Modifier
                .height(60.dp)
                .fillMaxWidth()
                .constrainAs(userNameEditText) {
                    width = Dimension.fillToConstraints
                    top.linkTo(icon.bottom, 40.dp)
                    start.linkTo(parent.start, 40.dp)
                    end.linkTo(parent.end, 40.dp)
                },
            trailingIcon = {
                Icon(Icons.Default.Person, contentDescription = null, tint = Color.Black)
            },
            colors = TextFieldDefaults.textFieldColors(
                textColor = Color.Black,
                focusedIndicatorColor = Color.Black,
                unfocusedIndicatorColor = Color.Black,
                backgroundColor = Color.Transparent
            )
        )
        TextField(
            value = passwordTextValue,
            onValueChange = { newValue -> passwordTextValue = newValue },
            label = {
                Text(text = "Password", color = Color.Black)
            },
            singleLine = true,
            modifier = Modifier
                .height(60.dp)
                .fillMaxWidth()
                .constrainAs(passwordEditText) {
                    width = Dimension.fillToConstraints
                    top.linkTo(userNameEditText.bottom, 20.dp)
                    start.linkTo(parent.start, 40.dp)
                    end.linkTo(parent.end, 40.dp)
                },
            trailingIcon = {
                Icon(Icons.Default.Lock, contentDescription = null, tint = Color.Black)
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            ),
            visualTransformation = PasswordVisualTransformation(),
            colors = TextFieldDefaults.textFieldColors(
                textColor = Color.Black,
                focusedIndicatorColor = Color.Black,
                unfocusedIndicatorColor = Color.Black,
                backgroundColor = Color.Transparent
            )
        )
    }
}

@Composable
fun GetStartedSection(
    modifier: Modifier = Modifier
) {
    ConstraintLayout(modifier = modifier) {
        val (text, icon) = createRefs()
        Text(
            text = "Get Started", modifier = Modifier
                .constrainAs(text) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(icon.start)
                }
        )

        Icon(
            Icons.Default.ArrowRightAlt, contentDescription = null, modifier = Modifier
                .fillMaxHeight()
                .constrainAs(icon) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(text.end)
                    end.linkTo(parent.end)
                }, tint = Color.White
        )
    }
}

@Composable
fun BottomNavSection(modifier: Modifier = Modifier) {
    Row(modifier = modifier.padding(top = 30.dp) ) {
        Text(text = "Create Account",modifier = Modifier
            .wrapContentSize()
            .weight(0.4f), textAlign = TextAlign.Center)
        Text(text = "/", modifier = Modifier.weight(0.2f).wrapContentSize())
        Text(text = "Forgot Password", modifier = Modifier
            .fillMaxSize()
            .weight(0.4f))
    }
}