package com.example.gateguardian.presentation.auth

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Apartment
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterAdminScreen(navController: NavController) {
    Column (
        modifier = Modifier.fillMaxSize()
    ) {
        TopAppBar(
            title = { Text(text = "Admin Registration",
                color = MaterialTheme.colorScheme.surface,
                fontWeight = FontWeight.Medium) },
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
        SocietyRegistration(navController = navController)
    }
}


@Composable
fun SocietyRegistration(
    navController: NavController
) {
    var adminName by remember { mutableStateOf("") }

    var societyName by remember { mutableStateOf("") }

    val keyboardController = LocalSoftwareKeyboardController.current

    Surface (
        modifier = Modifier.fillMaxSize()
    ) {
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)
        ) {

            OutlinedTextField(
                value = societyName,
                onValueChange = { societyName = it },
                enabled = true,
                modifier = Modifier
                    .padding(bottom = 10.dp, start = 10.dp, end = 10.dp)
                    .fillMaxWidth(),
                singleLine = true,
                placeholder ={ Text(text = "Society Name", color = MaterialTheme.colorScheme.onSurface) },
                leadingIcon = { Icon(imageVector = Icons.Rounded.Apartment, contentDescription = "Society Icon") },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Go
                ),
                keyboardActions = KeyboardActions(
                    onGo = { keyboardController?.hide() }
                )
            )

            OutlinedTextField(
                value = adminName,
                onValueChange = { adminName = it },
                enabled = true,
                modifier = Modifier
                    .padding(bottom = 10.dp, start = 10.dp, end = 10.dp)
                    .fillMaxWidth(),
                singleLine = true,
                placeholder ={ Text(text = "Your Name", color = MaterialTheme.colorScheme.onSurface) },
                leadingIcon = { Icon(imageVector = Icons.Rounded.AccountCircle, contentDescription = "Admin Icon") },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Go
                ),
                keyboardActions = KeyboardActions(
                    onGo = { keyboardController?.hide() }
                )
            )
        }
    }
}