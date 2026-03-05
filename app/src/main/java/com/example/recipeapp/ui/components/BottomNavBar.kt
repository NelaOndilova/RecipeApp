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

@Composable
fun BottomBar(navController: NavController) {

    NavigationBar {

        NavigationBarItem(
            selected = false,
            onClick = { navController.navigate("home") },
            label = { Text("Home") },
            icon = {
                Icon(Icons.Filled.Home, contentDescription = "Home")
            }
        )

        NavigationBarItem(
            selected = false,
            onClick = { navController.navigate("addRecipe") },
            label = { Text("Add Recipe") },
            icon = {
                Icon(Icons.Filled.Add, contentDescription = "Add recipe")
            }
        )

        NavigationBarItem(
            selected = false,
            onClick = { navController.navigate("favorites") },
            label = { Text("Favorites") },
            icon = {
                Icon(Icons.Filled.Favorite, contentDescription = "Favorite")
            }
        )

        NavigationBarItem(
            selected = false,
            onClick = { navController.navigate("profile") },
            label = { Text("Profile") },
            icon = {
                Icon(Icons.Filled.Person, contentDescription = "Profile")
            }
        )
    }
}
