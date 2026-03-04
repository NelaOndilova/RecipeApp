package com.example.recipeapp.ui.components

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun BottomBar(navController: NavController) {

    NavigationBar {

        NavigationBarItem(
            selected = false,
            onClick = { navController.navigate("home") },
            label = { Text("Home") },
            icon = {}
        )

        NavigationBarItem(
            selected = false,
            onClick = { navController.navigate("addRecipe") },
            label = { Text("Add Recipe") },
            icon = {}
        )

        NavigationBarItem(
            selected = false,
            onClick = { navController.navigate("favorites") },
            label = { Text("Favorites") },
            icon = {}
        )

        NavigationBarItem(
            selected = false,
            onClick = { navController.navigate("profile") },
            label = { Text("Profile") },
            icon = {}
        )
    }
}
