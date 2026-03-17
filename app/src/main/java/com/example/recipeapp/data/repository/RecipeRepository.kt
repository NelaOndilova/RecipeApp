package com.example.recipeapp.data.repository

import androidx.compose.runtime.mutableStateListOf
import com.example.recipeapp.data.model.Recipe

object RecipeRepository {
    val recipes = mutableStateListOf<Recipe>()

}