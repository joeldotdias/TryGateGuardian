package com.example.gateguardian.presentation.auth

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Apartment
import androidx.compose.material3.Scaffold
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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.gateguardian.presentation.components.AuthTopBar
import com.example.gateguardian.presentation.components.InputForm

@Composable
fun RegisterAdminScreen(navController: NavController) {
    val focusManager = LocalFocusManager.current

    var societyName by remember { mutableStateOf("") }
    var adminName by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            AuthTopBar(
                title = "Admin Registration",
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
                value = societyName,
                label = "Society Name",
                onValChange = { societyName = it },
                icon = Icons.Rounded.Apartment,
                onImeAction = KeyboardActions(
                    onNext = { focusManager.moveFocus(FocusDirection.Down) }
                )
            )
            InputForm(
                value = adminName,
                label = "Your Name",
                onValChange = { adminName = it },
                icon = Icons.Rounded.AccountCircle,
                imeAction = ImeAction.Done,
                onImeAction = KeyboardActions(
                    onDone = { focusManager.clearFocus() }
                )
            )
        }
    }
}