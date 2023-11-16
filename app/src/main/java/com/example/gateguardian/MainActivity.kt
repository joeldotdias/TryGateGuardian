package com.example.gateguardian

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.gateguardian.presentation.navigation.AppNavigation
import com.example.gateguardian.ui.theme.GateGuardianTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GateGuardianTheme {
                AppNavigation()
            }
        }
    }
}