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
import com.example.recipeapp.ui.screens.RecipeScreen

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
            composable("home") { HomeScreen(navController) }
            composable("favorites") { FavoritesScreen() }
            composable("addRecipe") { AddRecipeScreen(navController) }
            composable("account") { AccountScreen() }
            composable("favorites") { FavoritesScreen() }
            composable("recipe/{recipeName}") { backStackEntry ->
                val recipeName = backStackEntry.arguments?.getString("recipeName")?: ""
                RecipeScreen(navController, recipeName) }
        }
    }
}