package com.example.gateguardian.presentation.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.gateguardian.R
import com.example.gateguardian.presentation.navigation.AppScreens

@Composable
fun StartScreen(
    navController: NavController
) {
    Surface (
        modifier = Modifier
            .fillMaxSize(),
        color = Color.White
    ) {
        Column (
            modifier = Modifier
                .height(800.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ){
            Spacer(modifier = Modifier.height(60.dp))
            AppLogo()

            Spacer(modifier = Modifier.height(20.dp))
            ShowOptions(navController)
        }
    }
}


@Composable
fun ShowOptions(
    navController: NavController
) {
    val registerClickedState = remember { mutableStateOf(false) }

    val loginButtonColor = if(!registerClickedState.value) Color.LightGray else Color.White
    val registerButtonColor = if(registerClickedState.value) Color.LightGray else Color.White


    Surface (
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {
        Card (
            modifier = Modifier
                .clip(RoundedCornerShape(topStart = 15.dp, topEnd = 15.dp, bottomEnd = 0.dp, bottomStart =  0.dp)),
            shape = RectangleShape,
            colors =  CardDefaults.cardColors(containerColor = Color(0xFAF04E42)) ,
            elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)
        ) {
            Column (
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(corner = CornerSize(15.dp))),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.Top
                ) {
                    Button(
                        modifier = Modifier
                            .height(40.dp)
                            .width(200.dp)
                            .clip(RoundedCornerShape(topStart = 13.dp, topEnd = 0.dp, bottomEnd = 0.dp, bottomStart =  13.dp)),
                        shape = RectangleShape,
                        colors = ButtonDefaults.buttonColors(containerColor = loginButtonColor),
                        onClick = {
                            registerClickedState.value = false
                        }
                    ) {
                        Text(text = "LOGIN",
                            color = Color.DarkGray,
                            fontWeight = FontWeight.Medium
                        )
                    }

                    Spacer(modifier = Modifier.width(3.dp))

                    Button(
                        modifier = Modifier
                            .height(40.dp)
                            .width(200.dp)
                            .clip(RoundedCornerShape(topStart = 0.dp, topEnd = 13.dp, bottomEnd = 13.dp, bottomStart = 0.dp)),
                        shape = RectangleShape,
                        colors = ButtonDefaults.buttonColors(containerColor = registerButtonColor),
                        elevation = ButtonDefaults.buttonElevation(10.dp),
                        onClick = {
                            registerClickedState.value = true
                        }
                    ) {
                        Text(text = "REGISTER",
                            color = Color.DarkGray,
                            fontWeight = FontWeight.Medium
                        )
                    }
                }

                if(registerClickedState.value)
                    ShowRegister(navController)
                else
                    ShowLoginOptions(navController)
            }
        }
    }
}


@Composable
fun ShowLoginOptions(
    navController: NavController
) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Spacer(modifier = Modifier.height(40.dp))
        Button(
            modifier = Modifier
                .height(70.dp)
                .width(220.dp),
            colors = ButtonDefaults.buttonColors(Color(0xFF44164C)),
            elevation = ButtonDefaults.buttonElevation(20.dp),
            onClick = {
                navController.navigate(route = AppScreens.ResidentLoginScreen.name)
            }
        ) {
            Text(text = "Resident Login",
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
        }
        Spacer(modifier = Modifier.height(40.dp))
        Button(
            modifier = Modifier
                .height(70.dp)
                .width(220.dp),
            colors = ButtonDefaults.buttonColors(Color(0xFF44164C)),
            elevation = ButtonDefaults.buttonElevation(20.dp),
            onClick = {
                navController.navigate(route = AppScreens.SecurityLoginScreen.name)
            }
        ) {
            Text(text = "Security Login",
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
        }
    }
}


@Composable
fun ShowRegister(
    navController: NavController
) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Spacer(modifier = Modifier.height(80.dp))
        Button(
            modifier = Modifier
                .height(70.dp)
                .width(220.dp),
            colors = ButtonDefaults.buttonColors(Color(0xFF44164C)),
            elevation = ButtonDefaults.buttonElevation(20.dp),
            onClick = {
                navController.navigate(route = AppScreens.RegisterAdminScreen.name)
            }
        ) {
            Text(text = "Register Admin",
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun AppLogo() {
    Image(painter =  painterResource(id = R.drawable.gate_guardian_logo_with_bg),
        contentDescription = "App Logo",
        modifier = Modifier.size(300.dp)
    )

    Text(
        text = "GateGuardian",
        color = Color(0xFF4A7E8C),
        style = MaterialTheme.typography.headlineMedium,
        fontWeight = FontWeight.Bold
    )
}