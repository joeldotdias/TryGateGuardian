package com.example.gateguardian.presentation.auth

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.gateguardian.presentation.navigation.AppScreens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ResidentLoginScreen(navController: NavController) {
    Surface (
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column (
            modifier = Modifier
                .fillMaxSize()
        ){
            TopAppBar(
                title = { Text(text = "Resident Login",
                    color = MaterialTheme.colorScheme.surface,
                    fontWeight = FontWeight.Medium) },
                //scrollBehavior = scrollBehavior,
                colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.onSurfaceVariant),
                modifier = Modifier.shadow(elevation = 5.dp),
                navigationIcon = {
                    IconButton(onClick = {
                        navController.popBackStack()
                    }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back Arrow",
                            tint = MaterialTheme.colorScheme.surface
                        )
                    }
                }
            )
            ResidentAuthentication(navController = navController)
        }
    }
}


@Composable
fun ResidentAuthentication(
    navController: NavController
) {
    var flatNumber by remember {
        mutableStateOf("")
    }

    var phoneNumber by remember {
        mutableStateOf("")
    }

    var otp by remember {
        mutableStateOf("")
    }

    val keyboardController = LocalSoftwareKeyboardController.current

    Surface (
        modifier = Modifier
    ) {
        Column (
            modifier = Modifier.padding(10.dp)
        ) {

            OutlinedTextField(
                value = flatNumber,
                onValueChange = { flatNumber = it },
                enabled = true,
                modifier = Modifier
                    .padding(bottom = 10.dp, start = 10.dp, end = 10.dp)
                    .fillMaxWidth(),
                singleLine = true,
                placeholder ={ Text(text = "Flat Number", color = MaterialTheme.colorScheme.onSurface) },
                leadingIcon = { Icon(imageVector = Icons.Rounded.Home, contentDescription = "Flat icon") },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(
                    onNext = { keyboardController?.hide() }
                )
            )

            OutlinedTextField(
                value = phoneNumber,
                onValueChange = { phoneNumber = it },
                enabled = true,
                modifier = Modifier
                    .padding(bottom = 10.dp, start = 10.dp, end = 10.dp)
                    .fillMaxWidth(),
                singleLine = true,
                placeholder ={ Text(text = "Phone Number", color = MaterialTheme.colorScheme.onSurface) },
                leadingIcon = { Icon(imageVector = Icons.Rounded.Phone, contentDescription = "Phone Icon") },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(
                    onNext = { keyboardController?.hide() }
                )
            )

            OutlinedTextField(
                value = otp,
                onValueChange = {otp = it},
                enabled = true,
                modifier = Modifier
                    .padding(10.dp)
                    .align(Alignment.CenterHorizontally),
                singleLine = true,
                placeholder = { Text(text = "Enter OTP", color = MaterialTheme.colorScheme.onSurface) },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Go
                ),
                visualTransformation = PasswordVisualTransformation(),
                keyboardActions = KeyboardActions (
                    onGo = {
                        keyboardController?.hide()
                    }
                )
            )

            Column (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(40.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
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
}