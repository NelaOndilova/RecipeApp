package com.example.recipeapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun AddRecipeScreen(navController: NavController) {

    var name by remember { mutableStateOf("") }
    var ingredients by remember { mutableStateOf("") }
    var instructions by remember { mutableStateOf("") }
    var category by remember { mutableStateOf("") }

    val textFieldColors = OutlinedTextFieldDefaults.colors(
        focusedTextColor = Color(0xFF8F757D),
        unfocusedTextColor = Color(0xFF8F757D),
        focusedContainerColor = Color.White,
        unfocusedContainerColor = Color.White,
        focusedBorderColor = Color(0xFF8F757D),
        unfocusedBorderColor = Color(0xFF8F757D),
        focusedLabelColor = Color(0xFF8F757D),
        unfocusedLabelColor = Color(0xFF8F757D),
        cursorColor = Color(0xFF8F757D)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {

        Text(
            text = "ADD RECIPE",
            fontSize = 20.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(20.dp))

        TextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Recipe name") },
            modifier = Modifier.fillMaxWidth(),
            colors = textFieldColors,
            shape = RoundedCornerShape(8.dp)
        )

        Spacer(modifier = Modifier.height(12.dp))

        TextField(
            value = category,
            onValueChange = { category = it },
            label = { Text("Category (Breakfast, Lunch, Dinner...)") },
            modifier = Modifier.fillMaxWidth(),
            colors = textFieldColors,
            shape = RoundedCornerShape(8.dp)
        )

        Spacer(modifier = Modifier.height(12.dp))

        TextField(
            value = ingredients,
            onValueChange = { ingredients = it },
            label = { Text("Ingredients") },
            modifier = Modifier.fillMaxWidth(),
            colors = textFieldColors,
            shape = RoundedCornerShape(8.dp)
        )

        Spacer(modifier = Modifier.height(12.dp))

        TextField(
            value = instructions,
            onValueChange = { instructions = it },
            label = { Text("Instructions") },
            modifier = Modifier.fillMaxWidth(),
            colors = textFieldColors,
            shape = RoundedCornerShape(8.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                navController.navigate("home")
            },
            modifier = Modifier.fillMaxWidth().height(50.dp),
            shape = RoundedCornerShape(25.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFFFB4C2),
                contentColor = Color(0xFF8F757D)
            )
        ) {

            Text("Add recipe",
                fontSize = 16.sp,
                color = Color(0xFFF08495)
                )

        }

    }
}
