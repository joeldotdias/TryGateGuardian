package com.example.gateguardian.presentation.security.logs

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp


@Composable
fun LogsScreen() {
    Surface (
        modifier = Modifier
            .fillMaxSize()
    ) {
        Text(text = "Logs", fontSize = 30.sp, textAlign = TextAlign.Center)
    }
}