package com.example.recipeapp.ui.components

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.ui.graphics.Color
@Composable
fun BottomBar(navController: NavController) {

    NavigationBar (containerColor = Color(0xFFFFCAD4)){

        NavigationBarItem(
            selected =  false,
            onClick = { navController.navigate("home") },
            label = { Text("Home", color = Color(0xFF822D3A)) },
            icon = {
                Icon(Icons.Filled.Home, contentDescription = "Home", tint = Color(0xFFF08495))
            }
        )

        NavigationBarItem(
            selected = false,
            onClick = { navController.navigate("addRecipe") },
            label = { Text("Add Recipe", color = Color(0xFF822D3A)) },
            icon = {
                Icon(Icons.Filled.Add, contentDescription = "Add recipe", tint = Color(0xFFF08495))
            }
        )

        NavigationBarItem(
            selected = false,
            onClick = { navController.navigate("favorites") },
            label = { Text("Favorites", color = Color(0xFF822D3A)) },
            icon = {
                Icon(Icons.Filled.Favorite, contentDescription = "Favorite", tint = Color(0xFFF08495))
            }
        )

        NavigationBarItem(
            selected = false,
            onClick = { navController.navigate("account") },
            label = { Text("Account", color = Color(0xFF822D3A)) },
            icon = {
                Icon(Icons.Filled.Person, contentDescription = "Profile", tint = Color(0xFFF08495))
            }
        )
    }
}
