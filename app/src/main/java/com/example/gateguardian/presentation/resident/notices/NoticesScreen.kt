package com.example.gateguardian.presentation.resident.notices

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.gateguardian.presentation.widgets.CustomerSupportButtons


@Composable
fun NoticesScreen() {
    Surface (
        modifier = Modifier
            .fillMaxSize()
    ) {
        Text(text = "Notices", fontSize = 30.sp, textAlign = TextAlign.Center)

        CustomerSupportButtons()
    }
}