package com.example.recipeapp.data.repository

import com.example.recipeapp.data.model.Recipe
import com.example.recipeapp.data.local.RecipeDao

class RecipeRepository(private val recipeDao: RecipeDao) {
    suspend fun getAllRecipes(): List<Recipe>{
        return recipeDao.getAllRecipes()
    }
    suspend fun getFavoriteRecipes(): List<Recipe>{
        return recipeDao.getFavoriteRecipes()
    }
    suspend fun insertRecipe(recipe: Recipe) {
        return recipeDao.insertRecipe(recipe)
    }
    suspend fun updateRecipe(recipe: Recipe) {
        return recipeDao.updateRecipe(recipe)
    }
}