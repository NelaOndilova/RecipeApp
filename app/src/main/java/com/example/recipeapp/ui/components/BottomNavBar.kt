package com.example.recipeapp.ui.components

<<<<<<< HEAD
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
=======
>>>>>>> e00500d5978e9619235c729a911287c543a149a6
