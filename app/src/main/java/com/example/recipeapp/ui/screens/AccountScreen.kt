package com.example.recipeapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.compose.foundation.background
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AccountScreen(navController: NavController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = "ACCOUNT",
            fontSize = 20.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(24.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = Color(0xFFFFCAD4),
                    shape = RoundedCornerShape(20.dp)
                )
                .padding(20.dp)
        ) {

            Column {

                Text(
                    text = "Username",
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF8F757D)
                )

                Text(
                    text = "Your username",
                    color = Color(0xFF8F757D)
                )

                Text(
                    text = "Name",
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF8F757D)
                )

                Text(
                    text = "Your Name",
                    color = Color(0xFF8F757D)
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Email",
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF8F757D)
                )

                Text(
                    text = "your@email.com",
                    color = Color(0xFF8F757D)
                )
            }
        }
    }
}