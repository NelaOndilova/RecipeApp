package com.example.recipeapp.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.*
import com.example.recipeapp.ui.components.BottomBar
import com.example.recipeapp.ui.screens.AccountScreen
import com.example.recipeapp.ui.screens.AddRecipeScreen
import com.example.recipeapp.ui.screens.FavoritesScreen
import com.example.recipeapp.ui.screens.HomeScreen

@Composable
fun NavGraph() {

    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomBar(navController)
        }
    ) { paddingValues ->

        NavHost(
            navController = navController,
            startDestination = "home",
            modifier = Modifier.padding(paddingValues)
        ) {
            composable("home") { HomeScreen() }
            composable("favorites") { FavoritesScreen() }
            composable("addRecipe") { AddRecipeScreen() }
            composable("account") { AccountScreen() }
        }
    }
}
