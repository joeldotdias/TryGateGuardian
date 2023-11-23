package com.example.gateguardian.presentation.auth

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.Pin
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.gateguardian.presentation.components.AuthTopBar
import com.example.gateguardian.presentation.components.InputForm
import com.example.gateguardian.presentation.navigation.AppScreens

@Composable
fun ResidentLoginScreen(
    navController: NavController
) {
    val focusManager = LocalFocusManager.current

    var flatNumber by remember { mutableStateOf("") }
    var phoneNumber by remember { mutableStateOf("") }
    var otp by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            AuthTopBar(
                title = "Resident Login",
                navController = navController
            )
        }
    ) { topBarPadding ->
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(top = topBarPadding.calculateTopPadding() + 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            InputForm(
                value = flatNumber,
                label = "Flat Number",
                onValChange = { flatNumber = it },
                icon = Icons.Rounded.Home,
                keyboardType = KeyboardType.Number,
                onImeAction = KeyboardActions(
                    onNext = { focusManager.moveFocus(FocusDirection.Down) }
                )
            )
            InputForm(
                value = phoneNumber,
                label = "Phone Number",
                onValChange = { phoneNumber = it },
                icon = Icons.Rounded.Phone,
                keyboardType = KeyboardType.Number,
                onImeAction = KeyboardActions(
                    onNext = { focusManager.moveFocus(FocusDirection.Down) }
                )
            )
            InputForm(
                value = otp,
                label = "OTP",
                onValChange = { otp = it },
                keyboardType = KeyboardType.Number,
                icon = Icons.Rounded.Pin,
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier.padding(top = 20.dp, bottom = 40.dp, start = 40.dp, end = 40.dp),
                imeAction = ImeAction.Done,
                onImeAction = KeyboardActions(
                    onDone = { focusManager.clearFocus() }
                )
            )

            Button(
                onClick = {
                    navController.navigate(route = AppScreens.ResidentScreen.name)
                },
                modifier = Modifier
                    .height(50.dp)
                    .width(220.dp),
                elevation = ButtonDefaults.buttonElevation(12.dp),
            ) {
                Text(text = "Validate OTP")
            }
        }
    }
}