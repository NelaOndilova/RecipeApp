package com.example.recipeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.recipeapp.ui.theme.RecipeAppTheme
import com.example.recipeapp.navigation.NavGraph
import androidx.room.Room
import com.example.recipeapp.data.local.AppDatabase
import com.example.recipeapp.data.repository.RecipeRepository

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "recipe_database"
        ).build()
        val recipeRepository = RecipeRepository(db.recipeDao())
        setContent {
            RecipeAppTheme {
                    NavGraph(recipeRepository)
            }
        }
    }
}

